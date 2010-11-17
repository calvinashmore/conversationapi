/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conversation.core;

/**
 *
 * @author Calvin Ashmore
 */
public class DialogueBeat {

    //private DialogueNode initiatingNode;
    // initiating nodes are handled through NodeGroups.

    private Topic topic; // the topic to which this beat belongs

    private String description; // optional?

    private boolean starting; // whether this is a beat that can start a topic.

    private NodeGroup root;
}
