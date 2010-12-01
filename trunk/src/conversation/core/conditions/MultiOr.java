/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core.conditions;

import conversation.core.ConversationState;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class MultiOr extends Condition {

    private List<Condition> expressions;

    public MultiOr(List<Condition> expressions) {
        this.expressions = expressions;
    }

    @Override
    public boolean evaluate(ConversationState context) {

        for (Condition logicExpression : expressions) {
            if(logicExpression.evaluate(context))
                return true;
        }
        return false;
    }
}
