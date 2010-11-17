/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conversation.core;

/**
 *
 * @author lccstudent
 */
public class IntegerCondition {

    private String flagName;
    private int intValue;
    private Test test;

    public enum Test {
        equals, greaterThan, lessThan, greaterThanOrEqualTo, lessThanOrEqualTo
    }

}
