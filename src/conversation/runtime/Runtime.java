/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.runtime;

import conversation.core.Conversation;
import conversation.core.ConversationState;
import conversation.core.DialogueAgent;
import conversation.core.DialogueBeat;
import conversation.core.DialogueNode;
import conversation.core.NodeGroup;
import conversation.core.Topic;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<Topic, RuntimeTopic> topics = new HashMap<Topic, RuntimeTopic>();
    private Map<DialogueBeat, RuntimeBeat> beats = new HashMap<DialogueBeat, RuntimeBeat>();
    private Map<DialogueNode, RuntimeNode> nodes = new HashMap<DialogueNode, RuntimeNode>();

    
}
