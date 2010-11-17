/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.utils.logic;

/**
 *
 * @author Calvin Ashmore
 */
class SymbolConstant extends SymbolExpression {

    private Object value;

    public SymbolConstant(Object value) {
        this.value = value;
    }

    @Override
    public Object evaluate(LogicContext context) {
        return value;
    }
}
