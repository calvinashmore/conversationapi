/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.utils.logic;

/**
 *
 * @author Calvin Ashmore
 */
class Or extends LogicExpression {

    private LogicExpression left;
    private LogicExpression right;

    // other constructor?
    public Or(LogicExpression left, LogicExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean evaluate(LogicContext context) {
        boolean leftResult = left.evaluate(context);
        // short circuit if the left result is true
        if(leftResult)
            return true;
        
        boolean rightResult = right.evaluate(context);
        return rightResult;
    }
}
