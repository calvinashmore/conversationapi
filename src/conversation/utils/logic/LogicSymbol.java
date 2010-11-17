/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.utils.logic;

/**
 *
 * @author Calvin Ashmore
 */
class LogicSymbol extends LogicExpression {

    private SymbolExpression symbolExpression;

    @Override
    public boolean evaluate(LogicContext context) {
        Object result = symbolExpression.evaluate(context);

        // this may explode.
        return (Boolean) result;
    }
}
