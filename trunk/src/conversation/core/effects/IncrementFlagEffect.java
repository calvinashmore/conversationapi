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
public class IncrementFlagEffect extends Effect {

    private String name;

    public IncrementFlagEffect(String name) {
        this.name = name;
    }

    @Override
    public void apply(ConversationState state) {
        state.incrementFlag(name);
    }
}
