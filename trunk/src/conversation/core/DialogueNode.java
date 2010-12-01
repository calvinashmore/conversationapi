/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

import conversation.core.effects.Effect;
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
final public class DialogueNode extends Node {

//    final private String description; // optional?
    final private String label;
    DialogueBeat beat; // the beat to which this node belongs
//    final private DialogueAgent agent; // the agent who speaks this node. This IS a part of the authoring, not the runtime.
    final private Condition condition;
//    final private boolean starting; // whether this node can start a beat.
//    private NodeGroup group; // the group to which this node belongs.
    final private List<Effect> effects;
    final private Map<String, Object> attributes;

    protected DialogueNode(Builder builder) {
//        this.description = builder.description;
        this.label = builder.label;
//        this.beat = builder.beat;
//        this.agent = builder.agent;
        this.condition = builder.condition;
//        this.starting = builder.starting;
        this.effects = Collections.unmodifiableList(new ArrayList<Effect>(builder.effects));
        this.attributes = Collections.unmodifiableMap(new HashMap<String, Object>(builder.attributes));
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    //private List<DialogueNode> potentialResponses; // the responses which will continue this beat.
    // how do we handle responses?
    // there are some nodes which will perpetuate the beat,
    // and there are others which will switch to a different beat
    // and there are others which go into a whole topic.
    // CONDITION that enables this node (or a response)?
//    public DialogueAgent getAgent() {
//        return agent;
//    }

    public DialogueBeat getBeat() {
        return beat;
    }

    public String getLabel() {
        return label;
    }
//
//    public String getDescription() {
//        return description;
//    }



//    public boolean isStarting() {
//        return starting;
//    }
    public List<Effect> getEffects() {
        return effects;
    }

    public Condition getCondition() {
        return condition;
    }

    final public static class Builder {

//        public String description; // optional?
        public String label;
//        public DialogueBeat beat; // the beat to which this node belongs
//        public DialogueAgent agent; // the agent who speaks this node. This IS a part of the authoring, not the runtime.
        public Condition condition = Condition.TRUE_CONDITION;
//        public boolean starting; // whether this node can start a beat.
        //    private NodeGroup group; // the group to which this node belongs.
        public List<Effect> effects = new ArrayList<Effect>();
        public Map<String, Object> attributes = new HashMap<String, Object>();

        public DialogueNode build() {
            return new DialogueNode(this);
        }
    }
}
