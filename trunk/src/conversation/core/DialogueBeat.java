/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

/**
 *
 * @author Calvin Ashmore
 */
public class DialogueBeat {

    //private DialogueNode initiatingNode;
    // initiating nodes are handled through NodeGroups.
    private Condition condition;
    private Topic topic; // the topic to which this beat belongs
    private String description; // optional?
    private boolean starting; // whether this is a beat that can start a topic.
    private NodeGroup root;

    protected DialogueBeat(Builder builder) {
        this.condition = builder.condition;
        this.topic = builder.topic;
        this.description = builder.description;
        this.starting = builder.starting;
        this.root = builder.root;
    }

    public Condition getCondition() {
        return condition;
    }

    public String getDescription() {
        return description;
    }

    public NodeGroup getRoot() {
        return root;
    }

    public boolean isStarting() {
        return starting;
    }

    public Topic getTopic() {
        return topic;
    }

    public class Builder {

        public Condition condition;
        public Topic topic;
        public String description;
        public boolean starting;
        public NodeGroup root;

        public DialogueBeat build() {
            return new DialogueBeat(this);
        }
    }
}
