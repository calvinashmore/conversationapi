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
final public class DialogueAgent {

//    private String name; // or id?
    private String nickname;
    private Map<String, Object> attributes = new HashMap<String, Object>();

    public Map<String, Object> getAttributes() {
        return attributes;
    }

//    public String getName() {
//        return name;
//    }
    public String getNickname() {
        return nickname;
    }

    public DialogueAgent(String nickname) {
        this.nickname = nickname;
    }
    // information for mood or state??
    // maybe make this a final class which has state variables. Client code can
    // create an agent object and manipulate it?
    // alternately have this subclassable and allow implementation specific things to get involved,
    // for example: mood, 
}
