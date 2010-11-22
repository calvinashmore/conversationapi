/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
public final class ConversationState {

    private Map<String, Object> stateData = new HashMap<String, Object>();
    private List<String> clearOnBeat = new ArrayList<String>();
    private List<String> clearOnTopic = new ArrayList<String>();

    @Override
    public ConversationState clone() {
        ConversationState newState = new ConversationState();
        newState.clearOnBeat.addAll(clearOnBeat);
        newState.clearOnTopic.addAll(clearOnTopic);
        newState.stateData.putAll(stateData);
        return newState;
    }

    public void putFlag(String name, Object value) {
        stateData.put(name, value);
    }

    public void putBeatFlag(String name, Object value) {
        stateData.put(name, value);
        clearOnBeat.add(name);
    }

    public void putTopicFlag(String name, Object value) {
        stateData.put(name, value);
        clearOnTopic.add(name);
    }

    public void newBeat() {
        for (String flagName : clearOnBeat) {
            stateData.remove(flagName);
        }
    }

    public void newTopic() {
        for (String flagName : clearOnTopic) {
            stateData.remove(flagName);
        }
    }

    public Object getFlag(String name) {
        return stateData.get(name);
    }

    public void incrementFlag(String name) {
        Integer value = (Integer) getFlag(name);
        if (value == null) {
            value = 0;
        }
        putFlag(name, value + 1);
    }

    public void decrementFlag(String name) {
        Integer value = (Integer) getFlag(name);
        if (value == null) {
            value = 0;
        }
        putFlag(name, value - 1);
    }
}
