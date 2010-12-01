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
public class SymbolConstant extends SymbolExpression {

    private Object value;

    public SymbolConstant(Object value) {
        this.value = value;
    }

    @Override
    public Object evaluate(ConversationState context) {
        return value;
    }
}
