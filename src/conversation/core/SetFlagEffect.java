/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

/**
 *
 * @author Calvin
 */
public class SetFlagEffect extends Effect {

    final private String name;
    final private Object value;

    public SetFlagEffect(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void apply(ConversationState state) {
        state.putFlag(name, value);
    }
}
