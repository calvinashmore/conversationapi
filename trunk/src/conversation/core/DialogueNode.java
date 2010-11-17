/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

/**
 *
 * @author Calvin Ashmore
 */
public abstract class DialogueNode {

    private String description; // optional?
    private DialogueBeat beat; // the beat to which this node belongs
    private DialogueAgent agent; // the agent who speaks this node. This IS a part of the authoring, not the runtime.

    private boolean starting; // whether this node can start a beat.

    private NodeGroup group; // the group to which this node belongs.

    //private List<DialogueNode> potentialResponses; // the responses which will continue this beat.
    // how do we handle responses?
    // there are some nodes which will perpetuate the beat,
    // and there are others which will switch to a different beat
    // and there are others which go into a whole topic.
    // CONDITION that enables this node (or a response)?
    abstract public boolean enabled(ConversationState state);

    public DialogueAgent getAgent() {
        return agent;
    }

    public DialogueBeat getBeat() {
        return beat;
    }

    public String getDescription() {
        return description;
    }
}
