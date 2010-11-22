/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

/**
 *
 * @author Calvin Ashmore
 */
public class Topic {

    final private Condition condition;
    final private String description; // optional?
    final private boolean starting; // whether this topic can start a conversation.

    protected Topic(Builder builder) {
        this.condition = builder.condition;
        this.description = builder.description;
        this.starting = builder.starting;
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
    // list of nodes which can initiate this topic?
    // CONDITION that enables the topic?

    public static class Builder {

        public Condition condition;
        public String description; // optional?
        public boolean starting; // whether this topic can start a conversation.

        public Topic build() {
            return new Topic(this);
        }
    }
}
