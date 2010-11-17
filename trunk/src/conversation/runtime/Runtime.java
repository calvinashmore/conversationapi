/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.runtime;

import conversation.core.ConversationState;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class Runtime {

    // current state of the conversation
    private RuntimeTopic currentTopic;
    private RuntimeBeat currentBeat;
    private RuntimeNode lastNode;
    // the variables present in the conversation.
    private ConversationState state;
    private List<RuntimeTopic> pastTopics;
}
