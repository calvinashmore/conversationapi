/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.utils.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Calvin Ashmore
 */
public class LogicUtils {

    // static utility class
    private LogicUtils() {
    }

    public static LogicExpression parse(String expression) {

        // work goes here!
        return null;
    }

    private List<String> tokenize(String s) {
        // SUPPOSEDLY
        // there is a better way to do this with the REGEX package,
        // however, I can see no way for actually returning delimiters with regex.
        // we need delimiters, so we use StringTokenizer for now.

        StringTokenizer tokenizer = new StringTokenizer(s, "&|!()=<>", true);
        List<String> r = new ArrayList();
        while (tokenizer.hasMoreTokens()) {
            r.add(tokenizer.nextToken());
        }
        return r;
    }
}
