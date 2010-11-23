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
public class NodeGroup extends Node {

    protected NodeGroup(Builder builder) {
        this.type = builder.type;
        this.nodes = Collections.unmodifiableList(new ArrayList<Node>(builder.nodes));
        this.starting = builder.starting;
    }

    public static enum Type {

        optional, sequential
    }
    private Type type;
    private List<Node> nodes;
    private boolean starting;

    public List<Node> getNodes() {
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
        public List<Node> nodes = new ArrayList<Node>();
        public boolean starting;

        public NodeGroup build() {
            return new NodeGroup(this);
        }
    }
}
