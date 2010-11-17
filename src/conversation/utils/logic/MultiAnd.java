/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.utils.logic;

import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
class MultiAnd extends LogicExpression {

    private List<LogicExpression> expressions;

    public MultiAnd(List<LogicExpression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public boolean evaluate(LogicContext context) {

        for (LogicExpression logicExpression : expressions) {
            if (!logicExpression.evaluate(context)) {
                return false;
            }
        }
        return true;
    }
}
