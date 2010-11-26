/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.basic.example;

import conversation.basic.BasicNode;
import conversation.core.Conversation;
import conversation.core.DialogueAgent;
import conversation.core.DialogueBeat;
import conversation.core.NodeGroup;
import conversation.core.Topic;
import conversation.runtime.Runtime;

/**
 *
 * @author Calvin Ashmore
 */
public class ExampleConversation extends Conversation {

    public ExampleConversation() {

        DialogueAgent rick = new DialogueAgent("Rick");
        DialogueAgent brian = new DialogueAgent("Brian");


        Topic.Builder topicBuilder = new Topic.Builder();
        DialogueBeat.Builder beatBuilder = new DialogueBeat.Builder();
        BasicNode.Builder nodeBuilder = new BasicNode.Builder();
        NodeGroup.Builder groupBuilder = new NodeGroup.Builder();


        topicBuilder.description = "welcome";
        Topic topic = topicBuilder.build();
        getAllTopics().add(topic);

        beatBuilder.starting = true;
        beatBuilder.topic = topic;

//        nodeBuilder.beat = beat;
        nodeBuilder.agent = rick;
        nodeBuilder.content = "Hey there";
        groupBuilder.nodes.add(nodeBuilder.build());

        nodeBuilder.content = "I bought you a latte, but it's a bit cold now.";
        groupBuilder.nodes.add(nodeBuilder.build());
        
        groupBuilder.type = NodeGroup.Type.sequential;
        beatBuilder.root = groupBuilder.build();

        topic.getBeats().add(beatBuilder.build());
    }

    public static void main(String args[]) {
        Runtime runtime = new conversation.runtime.Runtime(new ExampleConversation());

        runtime.startConversation();
    }
}
