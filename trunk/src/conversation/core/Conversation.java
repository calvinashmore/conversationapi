/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class Conversation {

    private List<DialogueNode> allNodes = new ArrayList<DialogueNode>();
    private List<DialogueBeat> allBeats = new ArrayList<DialogueBeat>();
    private List<Topic> allTopics = new ArrayList<Topic>();
    private ConversationState initialState = new ConversationState();

}
