/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

import conversation.core.conditions.Condition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
final public class Topic {

    final private String label;
    final private Condition condition;
//    final private String description; // optional?
    final private boolean starting; // whether this topic can start a conversation.
    final private List<DialogueBeat> beats;
    final private Map<String, Object> attributes;

    protected Topic(Builder builder) {
        this.condition = builder.condition;
        this.label = builder.label;
//        this.description = builder.description;
        this.starting = builder.starting;
        this.beats = new ArrayList<DialogueBeat>(builder.beats);
        //Collections.unmodifiableList(new ArrayList<DialogueBeat>(builder.beats));
        this.attributes = Collections.unmodifiableMap(new HashMap<String, Object>(builder.attributes));
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public Condition getCondition() {
        return condition;
    }

    public String getLabel() {
        return label;
    }

//    public String getDescription() {
//        return description;
//    }



    public boolean isStarting() {
        return starting;
    }

    public List<DialogueBeat> getBeats() {
        return beats;
    }

    final public static class Builder {

        public Condition condition = Condition.TRUE_CONDITION;
//        public String description; // optional?
        public String label;
        public boolean starting = false; // whether this topic can start a conversation.
        public List<DialogueBeat> beats = new ArrayList<DialogueBeat>();
        public Map<String, Object> attributes = new HashMap<String, Object>();

        public Topic build() {
            Topic topic = new Topic(this);
            for (DialogueBeat dialogueBeat : topic.beats) {
                dialogueBeat.topic = topic;
            }
            return topic;
        }
    }
}
