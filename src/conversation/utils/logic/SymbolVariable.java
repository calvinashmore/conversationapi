/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.utils.logic;

/**
 *
 * @author Calvin Ashmore
 */
class SymbolVariable extends SymbolExpression {

    private String name;

    public SymbolVariable(String name) {
        this.name = name;
    }

    @Override
    public Object evaluate(LogicContext context) {
        return context.getValue(name);
    }
}
