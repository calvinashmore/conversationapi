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
import conversation.core.Topic;
import java.util.ArrayList;
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

    public Runtime(Conversation conversation) {
        this.conversation = conversation;
    }

    public void startConversation() {
        this.currentState = conversation.getInitialState().clone();
        List<Topic> topics = getEnabledTopics(true);
        List<DialogueBeat> beats = new ArrayList<DialogueBeat>();
        for (Topic topic : topics) {
            beats.addAll(getEnabledBeats(topic, true));
        }

        // get the node/group pairs
        List<Pair<NodeGroup, DialogueNode>> nodesAndGroups = new ArrayList<Pair<NodeGroup, DialogueNode>>();
        for (DialogueBeat beat : beats) {
            nodesAndGroups.addAll(getNodeChoices(beat));
        }

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
     * This returns the choices from the given place in conversation.
     * If a singleton is returned, then there is only one option, if an empty list is returned, then the conversation is over.
     * Otherwise there will need to be a choice.
     * @return
     */
    private List<Pair<NodeGroup, DialogueNode>> getCurrentNodeChoices() {
        List<Pair<NodeGroup, DialogueNode>> choices = new ArrayList<Pair<NodeGroup, DialogueNode>>();

        // look in the current group, manipulate.
        // if we are in a block which provides a topic or beat break, search those too.
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

        currentTopic = runtimeTopic;
        currentBeat = runtimeBeat;
        lastNode = runtimeNode;
        currentGroup = group; // needs more?
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

    protected List<DialogueBeat> getEnabledBeats(Topic topic, boolean startingOnly) {
        List<DialogueBeat> beats = new ArrayList<DialogueBeat>();
        for (DialogueBeat beat : topic.getBeats()) {
            if (startingOnly && !beat.isStarting()) {
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
    private List<Pair<NodeGroup, DialogueNode>> getNodeChoices(DialogueBeat beat) {
        return getNodeChoices(beat.getRoot(), new ArrayList<Pair<NodeGroup, DialogueNode>>());
    }

    private List<Pair<NodeGroup, DialogueNode>> getNodeChoices(NodeGroup ng, List<Pair<NodeGroup, DialogueNode>> current) {

        // this collects the possible choices if we are starting a beat.

        if (ng.getType() == NodeGroup.Type.optional) {
            // with optional node groups, we add everything
            for (Node option : ng.getNodes()) {
                if (option instanceof DialogueNode) {
                    current.add(new Pair<NodeGroup, DialogueNode>(ng, (DialogueNode) option));
                } else if (option instanceof NodeGroup) {
                    getNodeChoices((NodeGroup) option, current);
                }
            }
        } else if (ng.getType() == NodeGroup.Type.sequential) {

            // with sequential node groups, we add only the first entry.
            if (!ng.getNodes().isEmpty()) {
                Node option = ng.getNodes().get(0);

                if (option instanceof DialogueNode) {
                    current.add(new Pair<NodeGroup, DialogueNode>(ng, (DialogueNode) option));
                } else if (option instanceof NodeGroup) {
                    getNodeChoices((NodeGroup) option, current);
                }
            } else {
                // should not get here. Handle?
            }
        }
        return current;
    }
}
