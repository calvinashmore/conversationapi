/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.parser;

import conversation.basic.BasicNode;
import conversation.core.Condition;
import conversation.core.Conversation;
import conversation.core.DialogueAgent;
import conversation.core.DialogueBeat;
import conversation.core.DialogueNode;
import conversation.core.NodeGroup;
import conversation.core.Topic;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Calvin
 */
public class Converter {

    //private DialogueNode.Builder nodeBuilder;
    private BasicNode.Builder nodeBuilder;
//    private NodeGroup.Builder groupBuilder;
    private DialogueBeat.Builder beatBuilder;
    private Topic.Builder topicBuilder;

    public Converter(BasicNode.Builder nodeBuilder, DialogueBeat.Builder beatBuilder, Topic.Builder topicBuilder) {
        this.nodeBuilder = nodeBuilder;
//        this.groupBuilder = groupBuilder;
        this.beatBuilder = beatBuilder;
        this.topicBuilder = topicBuilder;
    }
    private Map<String, DialogueAgent> agents;

    public Conversation buildConversation(ASTConversationTopLevel topNode) {

        Conversation conversation = new Conversation();

        agents = new HashMap<String, DialogueAgent>();
        for (String agentName : topNode.getParticipants()) {
            DialogueAgent agent = new DialogueAgent(agentName);
            conversation.addAgent(agent);
            agents.put(agentName, agent);
        }

        for (ASTTopicNode topicNode : topNode.getTopics()) {
            Topic topic = buildTopic(topicNode);
            conversation.getAllTopics().add(topic);
        }
        return conversation;
    }

    protected Topic buildTopic(ASTTopicNode topicNode) {
        topicBuilder.condition = Condition.TRUE_CONDITION;
        topicBuilder.description = topicNode.getName();
        topicBuilder.starting = topicNode.isStarting();

        topicBuilder.beats.clear();
        for (ASTBeatNode beatNode : topicNode.getBeats()) {
            DialogueBeat beat = buildBeat(beatNode);
            topicBuilder.beats.add(beat);
        }

        return topicBuilder.build();
    }

    protected DialogueBeat buildBeat(ASTBeatNode beatNode) {
        beatBuilder.condition = Condition.TRUE_CONDITION;
        beatBuilder.description = "";
        beatBuilder.starting = beatNode.isStarting();
        beatBuilder.root = buildGroup(beatNode.getRoot());
        return beatBuilder.build();
    }


    protected NodeGroup buildGroup(ASTGroupNode groupNode) {

        NodeGroup.Builder groupBuilder = new NodeGroup.Builder();
        String type = groupNode.getType();
        if (type.equals("op")) {
            groupBuilder.type = NodeGroup.Type.optional;
        } else if (type.equals("seq")) {
            groupBuilder.type = NodeGroup.Type.sequential;
        }

        groupBuilder.nodes.clear();
        for (GroupContents contents : groupNode.getContents()) {
            if (contents instanceof ASTGroupNode) {
                groupBuilder.nodes.add(buildGroup((ASTGroupNode) contents));
            } else if (contents instanceof ASTLeafNode) {
                groupBuilder.nodes.add(buildNode((ASTLeafNode) contents));
            } else if (contents == ASTGroupNode.BEAT_BREAK) {
                groupBuilder.nodes.add(conversation.core.Node.BEAT_BREAK);
            } else if (contents == ASTGroupNode.TOPIC_BREAK) {
                groupBuilder.nodes.add(conversation.core.Node.TOPIC_BREAK);
            } else if (contents == ASTGroupNode.END_CONVERSATION) {
                groupBuilder.nodes.add(conversation.core.Node.CONVERSATION_END);
            }
        }
        return groupBuilder.build();
    }

    protected DialogueNode buildNode(ASTLeafNode leafNode) {

        nodeBuilder.agent = agents.get(leafNode.getSpeaker());
        nodeBuilder.condition = Condition.TRUE_CONDITION;
        nodeBuilder.content = leafNode.getContent();
        return nodeBuilder.build();
    }
}
