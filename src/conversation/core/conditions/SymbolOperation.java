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
public class SymbolOperation extends SymbolExpression {

    public enum Operation {

        add,
        subtract,
        multiply,
        divide
    }
    private SymbolExpression left;
    private SymbolExpression right;
    private Operation op;

    public SymbolOperation(SymbolExpression left, Operation op, SymbolExpression right) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public Object evaluate(ConversationState context) {
        double leftValue = SymbolExpression.asNumber(left.evaluate(context));
        double rightValue = SymbolExpression.asNumber(right.evaluate(context));

        switch (op) {
            case add:
                return leftValue + rightValue;
            case subtract:
                return leftValue - rightValue;
            case multiply:
                return leftValue * rightValue;
            case divide:
                return leftValue / rightValue;
        }

        // should not get here.
        return null;
    }
}
