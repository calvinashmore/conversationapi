/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.runtime;

import conversation.core.Conversation;
import conversation.core.ConversationState;
import conversation.core.DialogueBeat;
import conversation.core.DialogueNode;
import conversation.core.Node;
import conversation.core.NodeGroup;
import conversation.core.NodeLink;
import conversation.core.Topic;
import conversation.core.effects.Effect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import utils.Pair;

/**
 *
 * @author Calvin Ashmore
 */
public class Runtime {

    // current state of the conversation
    private Conversation conversation;
    private RuntimeTopic currentTopic;
    private RuntimeBeat currentBeat;
    private RuntimeNode lastNode;
    private NodeGroup currentGroup;
    // the variables present in the conversation.
    private ConversationState currentState;
    private Map<Topic, RuntimeTopic> deployedTopics = new HashMap<Topic, RuntimeTopic>();
    private Map<DialogueBeat, RuntimeBeat> deployedBeats = new HashMap<DialogueBeat, RuntimeBeat>();
    private Map<DialogueNode, RuntimeNode> deployedNodes = new HashMap<DialogueNode, RuntimeNode>();
    private Listener listener;

    public Conversation getConversation() {
        return conversation;
    }

    public RuntimeBeat getCurrentBeat() {
        return currentBeat;
    }

    public NodeGroup getCurrentGroup() {
        return currentGroup;
    }

    public ConversationState getCurrentState() {
        return currentState;
    }

    public RuntimeTopic getCurrentTopic() {
        return currentTopic;
    }

    public RuntimeNode getLastNode() {
        return lastNode;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {

        public void onNewNode(DialogueNode node);

        public void onNewBeat(DialogueBeat beat);

        public void onNewTopic(Topic topic);
    }

    public interface RuntimeSelector {

        public DialogueNode choose(List<DialogueNode> choices);
    }

    public Runtime(Conversation conversation) {
        this.conversation = conversation;
    }

    public void startConversation() {
        this.currentState = conversation.getInitialState().clone();

        List<Pair<NodeGroup, DialogueNode>> nodesAndGroups = getChoicesInConversation(true);

        List<DialogueNode> nodes = new ArrayList<DialogueNode>();
        for (Pair<NodeGroup, DialogueNode> pair : nodesAndGroups) {
            nodes.add(pair.getRight());
        }

        DialogueNode firstNode = select(nodes);
        NodeGroup group = null;
        for (Pair<NodeGroup, DialogueNode> pair : nodesAndGroups) {
            if (pair.getRight() == firstNode) {
                group = pair.getLeft();
            }
        }

        deploy(group, firstNode);
    }

    /**
     * returns false if there are no more legal moves?
     * @param selector
     * @return
     */
    public boolean step(RuntimeSelector selector) {
        List<Pair<NodeGroup, DialogueNode>> currentNodeChoices = getCurrentNodeChoices();
        if (currentNodeChoices == null || currentNodeChoices.isEmpty()) {
            return false;
        }

        List<DialogueNode> nodeList = new ArrayList<DialogueNode>();
        for (Pair<NodeGroup, DialogueNode> pair : currentNodeChoices) {
            nodeList.add(pair.getRight());
        }

        // perform the choice
        DialogueNode choice = selector.choose(nodeList);

        // deploy it
        for (Pair<NodeGroup, DialogueNode> pair : currentNodeChoices) {
            if (pair.getRight() == choice) {
                deploy(pair.getLeft(), choice);
                break;
            }
        }
        return true;
    }

    /**
     * This returns the choices from the given place in conversation.
     * If a singleton is returned, then there is only one option, if an empty list is returned, then the conversation is over.
     * Otherwise there will need to be a choice.
     * @return
     */
    private List<Pair<NodeGroup, DialogueNode>> getCurrentNodeChoices() {

        // we may be able to return quickly. 
        // if we were on a sequential node group, attempt to go to the next
        Node next;
//System.out.println("getCurrentNodeChoices");
        if (currentGroup.getType() == NodeGroup.Type.sequential) {
            // get the placement of the last node.
            int lastIndex = currentGroup.getNodes().indexOf(lastNode.getNode());

            if (currentGroup.getNodes().size() <= lastIndex + 1) {
                // need to go up a level
//System.out.println("  end and sequential: getNodeAfterGroupEnd");
                next = getNodeAfterGroupEnd(currentGroup);
            } else {
                // need to choose the next one
                // ********** IMPORTANT: this may not be enabled given conditions. What to do otherwise?
//System.out.println("  next sequential");
                next = currentGroup.getNodes().get(lastIndex + 1);
            }
        } else {
            // need to go up a level
//System.out.println("  end and optional: getNodeAfterGroupEnd");
            next = getNodeAfterGroupEnd(currentGroup);
        }
//System.out.println("  next: "+ next);

        // does this make sense????
//        if (next == null) {
//            List<Pair<NodeGroup, DialogueNode>> choices = getChoicesInTopic(currentTopic.getTopic(), false);
//            if (choices.isEmpty()) {
//                return getChoicesInConversation(false);
//            }
//        }

        // we have a node, there are several things it can be:
        // either a dialouge node, a group, or a break.
        return getChoicesFromNode(currentGroup, next);

        // look in the current group, manipulate.
        // if we are in a block which provides a topic or beat break, search those too.
    }

    /**
     * Here we are looking for the next node after the given group has ended.
     * @param ng
     * @return
     */
    private Node getNodeAfterGroupEnd(NodeGroup ng) {
        NodeGroup parent = ng.getParent();
        if (parent == null) {
            return null;
        }
        if (parent.getType() == NodeGroup.Type.sequential) {
            int lastIndex = parent.getNodes().indexOf(ng);
            if (parent.getNodes().size() <= lastIndex + 1) {
                // if this condition holds, we are at the end of the sequence.
                return getNodeAfterGroupEnd(parent);
            } else {
                return parent.getNodes().get(lastIndex + 1);
            }
        } else {
            return getNodeAfterGroupEnd(parent);
        }
    }

    private List<Pair<NodeGroup, DialogueNode>> getChoicesFromNode(NodeGroup parent, Node node) {
        if (node == null) {
            // reached a sequence end. Automatically look for another beat within the topic, or a new topic.
            List<Pair<NodeGroup, DialogueNode>> choices = getChoicesInTopic(currentTopic.getTopic(), false);
            if (!choices.isEmpty()) {
                return choices;
            }
            return getChoicesInConversation(false);
        }

        if (node instanceof DialogueNode) {
            // this is the simple case.

            // if we've already hit this node, discard.
            if (deployedNodes.containsKey((DialogueNode) node)) {
                return Collections.emptyList();
            }

            Pair<NodeGroup, DialogueNode> pair = new Pair<NodeGroup, DialogueNode>(parent, (DialogueNode) node);
            return Collections.singletonList(pair);
        } else if (node instanceof NodeGroup) {
            // entering a NEW NodeGroup, so start from the top.
            NodeGroup ng = (NodeGroup) node;
            if (ng.getType() == NodeGroup.Type.optional) {
                // return all options if we hit an optional node group.
                List<Pair<NodeGroup, DialogueNode>> r = new ArrayList<Pair<NodeGroup, DialogueNode>>();
                for (Node option : ng.getNodes()) {
                    r.addAll(getChoicesFromNode(ng, option));
                }
                return r;
            } else if (ng.getType() == NodeGroup.Type.sequential) {
                // return only the search results from the first element if we hit a sequential group.
                return getChoicesFromNode(ng, ng.getNodes().get(0));
            } else {
                // should not get here
                return null;
            }

        } else if (node instanceof NodeLink) {
            // hit a link, so attempt to find the targeted node.
            NodeLink nl = (NodeLink) node;
            Node target = nl.getNode(parent.getBeat());

            if (target == null) {
                // should not happen, but you know....
                throw new IllegalStateException("NodeLink could not find target: " + nl.getTarget());
            }
            return getChoicesFromNode(parent, target);

        } else if (node == Node.BEAT_BREAK) {
            // this is a beat break ONLY. We have to select a new beat within the topic.
            return getChoicesInTopic(currentTopic.getTopic(), false);
        } else if (node == Node.TOPIC_BREAK) {
            // this is a topic break ONLY. We have to select a new topic in the conversation.
            return getChoicesInConversation(false);
        } else if (node == Node.CONVERSATION_END) {
            return Collections.EMPTY_LIST;
        }
        // should not get here.
        return null;
    }

    private List<Pair<NodeGroup, DialogueNode>> getChoicesInTopic(Topic topic, boolean startingOnly) {
        List<DialogueBeat> enabledBeats = getEnabledBeats(topic, startingOnly);
        List<Pair<NodeGroup, DialogueNode>> choices = new ArrayList<Pair<NodeGroup, DialogueNode>>();
        for (DialogueBeat dialogueBeat : enabledBeats) {
            choices.addAll(getChoicesInBeat(dialogueBeat));
        }
        return choices;
    }

    private List<Pair<NodeGroup, DialogueNode>> getChoicesInConversation(boolean startingOnly) {
        List<Topic> enabledTopics = getEnabledTopics(startingOnly);
        List<DialogueBeat> enabledBeats = new ArrayList<DialogueBeat>();
        for (Topic topic : enabledTopics) {
            enabledBeats.addAll(getEnabledBeats(topic, true)); // true for starting new topics
        }
        List<Pair<NodeGroup, DialogueNode>> choices = new ArrayList<Pair<NodeGroup, DialogueNode>>();
        for (DialogueBeat dialogueBeat : enabledBeats) {
            choices.addAll(getChoicesInBeat(dialogueBeat));
        }
        return choices;
    }

    protected void deploy(NodeGroup group, DialogueNode node) {

        if (deployedNodes.get(node) != null) {
            // we should not get here.
            // assertion?
        }

        RuntimeNode runtimeNode = new RuntimeNode(node);
        deployedNodes.put(node, runtimeNode);

        // get the beat and handle it
        boolean newBeat = false;
        DialogueBeat beat = node.getBeat();
        RuntimeBeat runtimeBeat = deployedBeats.get(beat);
        if (runtimeBeat == null) {
            newBeat = true;
            runtimeBeat = new RuntimeBeat(beat);
            deployedBeats.put(beat, runtimeBeat);
        }
        runtimeBeat.addNode(runtimeNode);

        // get the topic and handle it
        Topic topic = beat.getTopic();
        RuntimeTopic runtimeTopic = deployedTopics.get(topic);
        if (runtimeTopic == null) {
            runtimeTopic = new RuntimeTopic(topic);
            deployedTopics.put(topic, runtimeTopic);
        }
        if (newBeat) {
            runtimeTopic.addBeat(runtimeBeat);
        }

        if (currentTopic != runtimeTopic) {
            listener.onNewTopic(topic);
        }
        if (currentBeat != runtimeBeat) {
            listener.onNewBeat(beat);
        }
        listener.onNewNode(node);

        currentTopic = runtimeTopic;
        currentBeat = runtimeBeat;
        lastNode = runtimeNode;
        currentGroup = group; // needs more?

        for (Effect effect : node.getEffects()) {
            effect.apply(currentState);
        }
    }
    // private random variable for use in select
    private static final Random random = new Random();

    /**
     * This chooses a node to deploy from a list of potential nodes.
     * Clients will need to override this method to provide specialized means of selections.
     * Alternately--- we could have an interface for a selection policy?
     * The dialogue node is NOT deployed in the implementation of this method, it is selection ONLY.
     * @param nodes
     * @return
     */
    protected DialogueNode select(List<DialogueNode> nodes) {

        // random for now.
        // nodes needs to be nonempty.
        // this is where NPC and PC agents would have some mechanic in selecting among nodes.
        return nodes.get(random.nextInt(nodes.size()));
    }

    protected List<Topic> getEnabledTopics(boolean startingOnly) {
        List<Topic> topics = new ArrayList<Topic>();
        for (Topic topic : conversation.getAllTopics()) {
            // discard non-starting topics if we are looking for starting only
            if (startingOnly && !topic.isStarting()) {
                continue;
            }

            // do not allow previously selected topics
            if (deployedTopics.get(topic) != null) {
                continue;
            }

            if (topic.getCondition().evaluate(currentState)) {
                topics.add(topic);
            }
        }
        // if search is empty and we are only searching for starting topics, broaden the search.
        if (topics.isEmpty() && startingOnly) {
            return getEnabledTopics(false);
        }
        return topics;
    }

    /**
     * Returns beats that are allowed in the given topic. 
     * @param topic
     * @param startingOnly
     * @return
     */
    protected List<DialogueBeat> getEnabledBeats(Topic topic, boolean startingOnly) {
        List<DialogueBeat> beats = new ArrayList<DialogueBeat>();
        for (DialogueBeat beat : topic.getBeats()) {
            if (startingOnly && !beat.isStarting()) {
                continue;
            }

            // do not allow previously selected beats
            if (deployedBeats.get(beat) != null) {
                continue;
            }

            if (beat.getCondition().evaluate(currentState)) {
                beats.add(beat);
            }
        }
        // if search is empty and we are only searching for starting beats, broaden the search.
        if (beats.isEmpty() && startingOnly) {
            return getEnabledBeats(topic, false);
        }
        return beats;
    }

    /**
     * Returns the possible node choices available in the given beat.
     * This is for NEW beats.
     * @param beat
     * @return
     */
    private List<Pair<NodeGroup, DialogueNode>> getChoicesInBeat(DialogueBeat beat) {
        return getChoicesFromNode(beat.getRoot(), beat.getRoot());
    }
}
