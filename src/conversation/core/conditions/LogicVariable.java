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
public class LogicVariable extends Condition {

    private String name;

    public LogicVariable(String name) {
        this.name = name;
    }

    @Override
    public boolean evaluate(ConversationState context) {
        Object flag = context.getFlag(name);
        if (flag == null) {
            return false;
        } else if (flag instanceof Boolean) {
            return (Boolean) flag;
        } else if (flag instanceof Integer) {
            return ((Integer) flag) != 0;
        } else if (flag instanceof Double) {
            return ((Double)flag) != 0;
        } else {
            // should not get here
            return false;
        }
    }
}
