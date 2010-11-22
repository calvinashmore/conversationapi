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

    public enum ClearState {

        never, beat, topic
    }
    final private String name;
    final private Object value;
    final private ClearState clearState;

    public SetFlagEffect(String name, Object value) {
        this.name = name;
        this.value = value;
        this.clearState = ClearState.never;
    }

    public SetFlagEffect(String name, Object value, ClearState clearState) {
        this.name = name;
        this.value = value;
        this.clearState = clearState;
    }

    @Override
    public void apply(ConversationState state) {
        switch (clearState) {
            case never:
                state.putFlag(name, value);
                break;
            case beat:
                state.putBeatFlag(name, value);
                break;
            case topic:
                state.putTopicFlag(name, value);
                break;
        }
    }
}
