/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core.conditions;

import conversation.core.ConversationState;

/**
 *
 * @author Calvin
 */
public class TestCondition extends Condition {

    public enum Operation {

        equals,
        greaterThan,
        greaterThanOrEqualTo,
        lessThan,
        lessThanOrEqualTo,
        notEqual
    }
    private SymbolExpression left;
    private SymbolExpression right;
    private Operation op;

    public TestCondition(SymbolExpression left, Operation op, SymbolExpression right) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public boolean evaluate(ConversationState context) {
        double leftValue = SymbolExpression.asNumber(left.evaluate(context));
        double rightValue = SymbolExpression.asNumber(right.evaluate(context));

        switch (op) {
            case equals:
                return leftValue == rightValue;
            case greaterThan:
                return leftValue > rightValue;
            case greaterThanOrEqualTo:
                return leftValue >= rightValue;
            case lessThan:
                return leftValue < rightValue;
            case lessThanOrEqualTo:
                return leftValue <= rightValue;
            case notEqual:
                return leftValue != rightValue;
        }
        // should not get here...
        return false;
    }
}
