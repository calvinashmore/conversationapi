/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

/**
 *
 * @author lccstudent
 */
public class IntegerCondition extends Condition {

    final private String flagName;
    final private int testValue;
    final private Test test;

    public IntegerCondition(String flagName, int testValue, Test test) {
        this.flagName = flagName;
        this.testValue = testValue;
        this.test = test;
    }

    public enum Test {

        equals, greaterThan, lessThan, greaterThanOrEqualTo, lessThanOrEqualTo
    }

    @Override
    public boolean evaluate(ConversationState state) {
        Object flag = state.getFlag(flagName);
        if (flag == null || !(flag instanceof Integer)) {
            //complain?
            return false;
        }

        int value = (Integer) flag;
        switch (test) {
            case equals:
                return value == testValue;
            case greaterThan:
                return value > testValue;
            case lessThan:
                return value < testValue;
            case greaterThanOrEqualTo:
                return value >= testValue;
            case lessThanOrEqualTo:
                return value <= testValue;
        }

        // should not reach here
        return false;
    }
}
