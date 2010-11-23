/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conversation.core;

/**
 *
 * @author lccstudent
 */
abstract public class Condition {

    public final static Condition TRUE_CONDITION = new ConstantCondition(true);
    public final static Condition FALSE_CONDITION = new ConstantCondition(false);

    abstract public boolean evaluate(ConversationState state);

    private static class   ConstantCondition extends Condition{

        private final boolean value;

        public ConstantCondition(boolean value) {
            this.value = value;
        }


        @Override
        public boolean evaluate(ConversationState state) {
            return value;
        }
    }
}
