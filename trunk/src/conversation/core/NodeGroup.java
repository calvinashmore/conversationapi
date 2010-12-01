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
final public class NodeGroup extends Node {

    protected NodeGroup(Builder builder) {
        this.type = builder.type;
        this.nodes = Collections.unmodifiableList(new ArrayList<Node>(builder.nodes));
//        this.starting = builder.starting;
//        this.parent = builder.parent;
    }

    void finish(DialogueBeat beat, NodeGroup parent) {
        for (Node node : nodes) {
            if (node instanceof NodeGroup) {
                ((NodeGroup) node).finish(beat, this);
            } else if (node instanceof DialogueNode) {
                ((DialogueNode) node).beat = beat;
            }
        }
    }

    public static enum Type {

        optional, sequential
    }
    private Type type;
    private List<Node> nodes;
//    private boolean starting;
    private NodeGroup parent;

    public NodeGroup getParent() {
        return parent;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public Type getType() {
        return type;
    }

//    public boolean isStarting() {
//        return starting;
//    }
    final public static class Builder {

        public Type type;
        public List<Node> nodes = new ArrayList<Node>();
//        public boolean starting;
//        public NodeGroup parent;

        public NodeGroup build() {
            return new NodeGroup(this);
        }
    }
}
