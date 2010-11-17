/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.utils.logic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
public class LogicContext {

    private Map<String, Object> values = new HashMap<String, Object>();

//    public LogicContext(Map<String, Object> values) {
//        this.values = values;
//    }
    public Map<String, Object> getValues() {
        return values;
    }

    public void putValue(String name, Object value) {
        values.put(name, value);
    }

    public Object getValue(String name) {
        return values.get(name);
    }
}
