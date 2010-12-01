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
public class LessThanOrEqualTo extends Condition {

    SymbolExpression left;
    SymbolExpression right;

    @Override
    public boolean evaluate(ConversationState context) {

        Number leftValue = (Number) left.evaluate(context);
        Number rightValue = (Number) right.evaluate(context);

        return leftValue.doubleValue() <= rightValue.doubleValue();
    }
}
