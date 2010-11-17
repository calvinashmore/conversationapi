/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.utils.logic;

/**
 *
 * @author Calvin Ashmore
 */
class Not extends LogicExpression {

    private LogicExpression expression;

    // other constructor?
    public Not(LogicExpression expression) {
        this.expression = expression;
    }

    @Override
    public boolean evaluate(LogicContext context) {
        return !expression.evaluate(context);
    }
}
