/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class Topic {

    final private Condition condition;
    final private String description; // optional?
    final private boolean starting; // whether this topic can start a conversation.
    final private List<DialogueBeat> beats;

    protected Topic(Builder builder) {
        this.condition = builder.condition;
        this.description = builder.description;
        this.starting = builder.starting;
        this.beats = new ArrayList<DialogueBeat>(builder.beats);
        //Collections.unmodifiableList(new ArrayList<DialogueBeat>(builder.beats));
    }

    public Condition getCondition() {
        return condition;
    }

    public String getDescription() {
        return description;
    }

    public boolean isStarting() {
        return starting;
    }

    public List<DialogueBeat> getBeats() {
        return beats;
    }

    public static class Builder {

        public Condition condition = Condition.TRUE_CONDITION;
        public String description; // optional?
        public boolean starting = false; // whether this topic can start a conversation.
        public List<DialogueBeat> beats = new ArrayList<DialogueBeat>();

        public Topic build() {
            return new Topic(this);
        }
    }
}
