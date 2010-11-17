/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conversation.core;

/**
 *
 * @author lccstudent
 */
abstract public class Condition {

    abstract public boolean evaluate(ConversationState state);
}
