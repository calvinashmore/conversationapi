/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.utils.logic;

/**
 * Logic Expression is protected. Use LogicUtils to generate instances from outside the package.
 * @author Calvin Ashmore
 */
abstract public class LogicExpression {

    LogicExpression() {
    }

    public abstract boolean evaluate(LogicContext context);
}
