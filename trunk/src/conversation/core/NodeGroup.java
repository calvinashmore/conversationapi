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
public class NodeGroup {

    protected NodeGroup(Builder builder) {
        this.type = builder.type;
        this.nodes = Collections.unmodifiableList(new ArrayList<DialogueNode>(builder.nodes));
        this.starting = builder.starting;
    }

    public static enum Type {

        optional, sequential
    }
    private Type type;
    private List<DialogueNode> nodes;
    private boolean starting;

    public List<DialogueNode> getNodes() {
        return nodes;
    }

    public Type getType() {
        return type;
    }

    public boolean isStarting() {
        return starting;
    }

    public static class Builder {

        public Type type;
        public List<DialogueNode> nodes = new ArrayList<DialogueNode>();
        public boolean starting;

        public NodeGroup build() {
            return new NodeGroup(this);
        }
    }
}
