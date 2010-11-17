/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.utils.logic;

/**
 *
 * @author Calvin Ashmore
 */
public class SymbolEquals extends LogicExpression {

    SymbolExpression left;
    SymbolExpression right;

    @Override
    public boolean evaluate(LogicContext context) {

        Object leftValue = left.evaluate(context);
        Object rightValue = right.evaluate(context);

        return leftValue == rightValue || leftValue.equals(rightValue);
    }
}
