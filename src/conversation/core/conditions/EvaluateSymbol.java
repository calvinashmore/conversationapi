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
public class EvaluateSymbol extends Condition {

    private SymbolExpression symbolExpression;

    @Override
    public boolean evaluate(ConversationState context) {
        Object result = symbolExpression.evaluate(context);

        // this may explode.
        return (Boolean) result;
    }
}
