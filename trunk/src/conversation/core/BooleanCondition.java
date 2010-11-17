/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

/**
 *
 * @author lccstudent
 */
public class BooleanCondition extends Condition {

    private String flagName;

    /**
     * The given flag must be non-null and true or nonzero
     * @param flagName
     */
    public BooleanCondition(String flagName) {
        this.flagName = flagName;
    }

    @Override
    public boolean evaluate(ConversationState state) {
        Object flag = state.getFlag(flagName);
        if (flag == null) {
            return false;
        }
        if (flag instanceof Boolean) {
            return (Boolean) flag;
        }
        if (flag instanceof Integer) {
            return ((Integer) flag) != 0;
        }

        // throw exception?
        return false;
    }
}
