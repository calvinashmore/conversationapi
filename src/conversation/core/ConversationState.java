/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
public class ConversationState {

    private Map<String, Object> stateData = new HashMap<String, Object>();
    
    public void putFlag(String name, Object value) {
        stateData.put(name, value);
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
