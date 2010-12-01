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
public class Not extends Condition {

    private Condition expression;

    // other constructor?
    public Not(Condition expression) {
        this.expression = expression;
    }

    @Override
    public boolean evaluate(ConversationState context) {
        return !expression.evaluate(context);
    }
}
