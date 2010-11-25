/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.runtime;

import conversation.core.DialogueAgent;
import conversation.core.DialogueNode;

/**
 *
 * @author Calvin Ashmore
 */
public class RuntimeNode {

    private DialogueNode node;

    RuntimeNode(DialogueNode node) {
        this.node = node;
    }

    public DialogueNode getNode() {
        return node;
    }
}
