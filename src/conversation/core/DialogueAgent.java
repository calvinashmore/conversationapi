/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

/**
 *
 * @author Calvin Ashmore
 */
public class DialogueAgent {

    private String name; // or id?

    public String getName() {
        return name;
    }

    public DialogueAgent(String name) {
        this.name = name;
    }
    // information for mood or state??
    // maybe make this a final class which has state variables. Client code can
    // create an agent object and manipulate it?
    // alternately have this subclassable and allow implementation specific things to get involved,
    // for example: mood, 
}
