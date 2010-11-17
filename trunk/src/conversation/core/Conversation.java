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

    private List<DialogueNode> allNodes;
    private List<DialogueBeat> allBeats;
    private List<Topic> allTopics;

    private List<DialogueNode> getPossibleNodes(DialogueAgent agent, ConversationState state) {

        // simple technique-
        List<DialogueNode> nodes = new ArrayList<DialogueNode>();
        for (DialogueNode dialogueNode : allNodes) {
            if (dialogueNode.getAgent() == agent && dialogueNode.enabled(state)) {
                nodes.add(dialogueNode);
            }
        }
        return nodes;
    }
}
