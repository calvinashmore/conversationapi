/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core.effects;

import conversation.core.ConversationState;

/**
 *
 * @author Calvin
 */
public class DecrementFlagEffect extends Effect {

    private String name;

    public DecrementFlagEffect(String name) {
        this.name = name;
    }

    @Override
    public void apply(ConversationState state) {
        state.decrementFlag(name);
    }
}
