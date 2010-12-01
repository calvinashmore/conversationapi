/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

import conversation.core.conditions.Condition;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
final public class DialogueBeat {

    //private DialogueNode initiatingNode;
    // initiating nodes are handled through NodeGroups.
    final private Condition condition;
    Topic topic; // the topic to which this beat belongs
//    final private String description; // optional?
    final private boolean starting; // whether this is a beat that can start a topic.
    final private NodeGroup root;
    final private Map<String, Object> attributes;
    final private String label;

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    protected DialogueBeat(Builder builder) {
        this.condition = builder.condition;
//        this.topic = builder.topic;
        this.label = builder.label;
//        this.description = builder.description;
        this.starting = builder.starting;
        this.root = builder.root;
        this.attributes = Collections.unmodifiableMap(new HashMap<String, Object>(builder.attributes));
    }

    public Condition getCondition() {
        return condition;
    }

    public String getLabel() {
        return label;
    }
//
//    public String getDescription() {
//        return description;
//    }

    public NodeGroup getRoot() {
        return root;
    }

    public boolean isStarting() {
        return starting;
    }

    public Topic getTopic() {
        return topic;
    }

    final public static class Builder {

        public Condition condition = Condition.TRUE_CONDITION;
//        public Topic topic;
//        public String description;
        public String label;
        public boolean starting;
        public NodeGroup root;
        public Map<String, Object> attributes = new HashMap<String, Object>();

        public DialogueBeat build() {
            DialogueBeat beat = new DialogueBeat(this);
            root.finish(beat, null);
            return beat;
        }
    }
}
