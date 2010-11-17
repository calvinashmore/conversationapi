/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.utils.logic;

/**
 *
 * @author Calvin Ashmore
 */
public class GreaterThanOrEqualTo extends LogicExpression {

    SymbolExpression left;
    SymbolExpression right;

    @Override
    public boolean evaluate(LogicContext context) {

        Number leftValue = (Number) left.evaluate(context);
        Number rightValue = (Number) right.evaluate(context);

        return leftValue.doubleValue() >= rightValue.doubleValue();
    }
}
