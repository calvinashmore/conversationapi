/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.runtime;

import conversation.core.Conversation;
import conversation.core.ConversationState;
import conversation.core.DialogueAgent;
import conversation.core.DialogueNode;
import conversation.core.NodeGroup;
import java.util.List;

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
    private ConversationState state;
    private List<RuntimeTopic> pastTopics;

    private List<DialogueNode> getPossibleNodes(DialogueAgent agent) {
        // returns the possible nodes that the agent can speak at this point
    }
}
