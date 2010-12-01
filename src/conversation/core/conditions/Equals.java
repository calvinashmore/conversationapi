/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core.conditions;

import conversation.core.ConversationState;

/**
 *
 * @author Calvin Ashmore
 */
public class Equals extends Condition {

    private Condition left;
    private Condition right;

    // other constructor?
    public Equals(Condition left, Condition right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean evaluate(ConversationState context) {
        boolean leftResult = left.evaluate(context);
        boolean rightResult = right.evaluate(context);

        return leftResult == rightResult;
    }
}
