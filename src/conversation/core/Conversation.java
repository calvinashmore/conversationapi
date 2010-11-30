/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
public class Conversation {

//    private List<DialogueNode> allNodes = new ArrayList<DialogueNode>();
//    private List<DialogueBeat> allBeats = new ArrayList<DialogueBeat>();
    private List<Topic> allTopics = new ArrayList<Topic>();
    private ConversationState initialState = new ConversationState();
    private Map<String, DialogueAgent> agents = new HashMap<String, DialogueAgent>();

//    public List<DialogueBeat> getAllBeats() {
//        return allBeats;
//    }
//
//    public List<DialogueNode> getAllNodes() {
//        return allNodes;
//    }

    public void addAgent(DialogueAgent agent) {
        agents.put(agent.getName(), agent);
    }

    public DialogueAgent getAgent(String name) {
        return agents.get(name);
    }

    public List<Topic> getAllTopics() {
        return allTopics;
    }

    public ConversationState getInitialState() {
        return initialState;
    }
}
