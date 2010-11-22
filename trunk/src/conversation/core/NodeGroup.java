/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conversation.core;

import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class NodeGroup {

    public static enum Type {
        optional, sequential
    }

    private Type type;
    private List<DialogueNode> nodes;


}
