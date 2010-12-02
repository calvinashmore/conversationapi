/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.parser.test;

import conversation.core.Conversation;
import conversation.core.DialogueBeat;
import conversation.core.DialogueNode;
import conversation.core.Topic;
import conversation.parser.Parser;
import conversation.runtime.Runtime;
import java.io.FileInputStream;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin
 */
public class Test {


    public static void main(String args[]) throws Exception {


        Parser parser = new Parser(new FileInputStream("src/test.conversation"));
        Conversation conversation = parser.ConversationTopLevel();

        
        Runtime runtime = new conversation.runtime.Runtime(conversation);

        Runtime.Listener listener = new Runtime.Listener() {

            public void onNewNode(DialogueNode node) {
                System.out.println("new node: "+(node).getAttributes());
            }

            public void onNewBeat(DialogueBeat beat) {
                System.out.println("new beat: "+beat.getLabel());
            }

            public void onNewTopic(Topic topic) {
                System.out.println("new topic: "+topic.getLabel());
            }
        };

        Runtime.RuntimeSelector selector = new Runtime.RuntimeSelector() {

            private Random random = new Random();
            public DialogueNode choose(List<DialogueNode> choices) {
                System.out.println("choosing among: "+choices);
                return choices.get(random.nextInt(choices.size()));
            }
        };

        runtime.setListener(listener);

        runtime.startConversation();

        while(runtime.step(selector)) {
            // do nothing
        }

    }
}
