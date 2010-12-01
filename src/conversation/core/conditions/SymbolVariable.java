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
public class SymbolVariable extends SymbolExpression {

    private String name;

    public SymbolVariable(String name) {
        this.name = name;
    }

    @Override
    public Object evaluate(ConversationState context) {
        return context.getFlag(name);
    }
}
