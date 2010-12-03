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
public abstract class SymbolExpression {

    abstract public Object evaluate(ConversationState context);

    static double asNumber(Object value) {
        if (value instanceof Integer) {
            return (Integer) value;
        } else if (value instanceof Double) {
            return (Double) value;
        } else if (value instanceof Boolean) {
            return (Boolean) value ? 1 : 0;
        } else {
            // should not get here?
            return 0;
        }
    }
}
