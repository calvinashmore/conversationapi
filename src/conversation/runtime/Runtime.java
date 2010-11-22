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
import java.util.ArrayList;
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
    private Map<Topic, RuntimeTopic> deployedTopics = new HashMap<Topic, RuntimeTopic>();
    private Map<DialogueBeat, RuntimeBeat> deployedBeats = new HashMap<DialogueBeat, RuntimeBeat>();
    private Map<DialogueNode, RuntimeNode> deployedNodes = new HashMap<DialogueNode, RuntimeNode>();

    public Runtime(Conversation conversation) {
        this.conversation = conversation;
    }

    public void startConversation() {
        this.currentState = conversation.getInitialState().clone();
        List<Topic> topics = getEnabledTopics(true);

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
}
