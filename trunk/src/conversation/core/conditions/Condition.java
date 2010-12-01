/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core.conditions;

import conversation.core.ConversationState;

/**
 * Logic Expression is protected. Use LogicUtils to generate instances from outside the package.
 * @author Calvin Ashmore
 */
abstract public class Condition {

    Condition() {
    }

    public abstract boolean evaluate(ConversationState context);

    public static final Condition TRUE_CONDITION = new Condition() {

        @Override
        public boolean evaluate(ConversationState context) {
            return true;
        }
    };

    public static final Condition FALSE_CONDITION = new Condition() {

        @Override
        public boolean evaluate(ConversationState context) {
            return false;
        }
    };
}
