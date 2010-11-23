/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.core;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class Node {

    // these are special case nodes,
    // basically a signal to break the node group and allow other beats or topics to enter.
    // note: this is not serialization safe.
    public static final Node BEAT_BREAK;
    public static final Node TOPIC_BREAK;

    static {

        BEAT_BREAK = new Node() {
        };
        TOPIC_BREAK = new Node() {
        };
    }
}
