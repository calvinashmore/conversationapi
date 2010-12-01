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
public class SymbolEquals extends Condition {

    SymbolExpression left;
    SymbolExpression right;

    @Override
    public boolean evaluate(ConversationState context) {

        Object leftValue = left.evaluate(context);
        Object rightValue = right.evaluate(context);

        return leftValue == rightValue || leftValue.equals(rightValue);
    }
}
