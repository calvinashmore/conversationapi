/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.utils.logic;

/**
 *
 * @author Calvin Ashmore
 */
class Equals extends LogicExpression {

    private LogicExpression left;
    private LogicExpression right;

    // other constructor?
    public Equals(LogicExpression left, LogicExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean evaluate(LogicContext context) {
        boolean leftResult = left.evaluate(context);
        boolean rightResult = right.evaluate(context);

        return leftResult == rightResult;
    }
}
