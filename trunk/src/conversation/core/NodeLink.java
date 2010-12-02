/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

/**
 * This links to another node, which is identified by its target name
 * @author Calvin
 */
public class NodeLink extends Node {

    private String target;

    public String getTarget() {
        return target;
    }

    public NodeLink(String target) {
        this.target = target;
    }

    public Node getNode(DialogueBeat currentBeat) {
        return searchNode(currentBeat.getRoot());
    }

    private Node searchNode(Node base) {
        if (base instanceof DialogueNode && target.equals(((DialogueNode) base).getLabel())) {
            return base;
        }
        if (base instanceof NodeGroup) {
            NodeGroup ng = (NodeGroup) base;
            if (target.equals(ng.getLabel())) {
                return ng;
            } else {
                for (Node child : ng.getNodes()) {
                    Node result = searchNode(child);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }
        return null;
    }
}
