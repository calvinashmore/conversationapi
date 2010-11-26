/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.parser.test;

import conversation.parser.ASTConversationTopLevel;
import conversation.parser.Parser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Calvin
 */
public class Test {

    public static void main(String args[]) throws Exception {


        Parser parser = new Parser(new FileInputStream("src/test.conversation"));
        ASTConversationTopLevel ConversationTopLevel = parser.ConversationTopLevel();
        
    }
}
