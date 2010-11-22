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
public class DialogueNode {

    // these are special case nodes,
    // basically a signal to break the node group and allow other beats or topics to enter.
    // note: this is not serialization safe.
    public static final DialogueNode beatBreak;
    public static final DialogueNode topicBreak;

    static {
        Builder builder = new Builder();
        builder.description = "Beat Break";
        beatBreak = builder.build();

        builder.description = "Topic Break";
        topicBreak = builder.build();
    }


    final private String description; // optional?
    final private DialogueBeat beat; // the beat to which this node belongs
    final private DialogueAgent agent; // the agent who speaks this node. This IS a part of the authoring, not the runtime.
    final private Condition condition;
    final private boolean starting; // whether this node can start a beat.
//    private NodeGroup group; // the group to which this node belongs.
    final private List<Effect> effects;

    protected DialogueNode(Builder builder) {
        this.description = builder.description;
        this.beat = builder.beat;
        this.agent = builder.agent;
        this.condition = builder.condition;
        this.starting = builder.starting;
        this.effects = Collections.unmodifiableList(new ArrayList<Effect>(builder.effects));
    }

    public Condition getCondition() {
        return condition;
    }

    //private List<DialogueNode> potentialResponses; // the responses which will continue this beat.
    // how do we handle responses?
    // there are some nodes which will perpetuate the beat,
    // and there are others which will switch to a different beat
    // and there are others which go into a whole topic.
    // CONDITION that enables this node (or a response)?
    public DialogueAgent getAgent() {
        return agent;
    }

    public DialogueBeat getBeat() {
        return beat;
    }

    public String getDescription() {
        return description;
    }

    public boolean isStarting() {
        return starting;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public static class Builder {

        private String description; // optional?
        private DialogueBeat beat; // the beat to which this node belongs
        private DialogueAgent agent; // the agent who speaks this node. This IS a part of the authoring, not the runtime.
        private Condition condition;
        public boolean starting; // whether this node can start a beat.
        //    private NodeGroup group; // the group to which this node belongs.
        public List<Effect> effects = new ArrayList<Effect>();

        public DialogueNode build() {
            return new DialogueNode(this);
        }
    }
}
