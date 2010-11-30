/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.basic;

import conversation.core.DialogueNode;

/**
 *
 * @author Calvin Ashmore
 */
public class BasicNode extends DialogueNode {

    private String content;

    public String getContent() {
        return content;
    }

    protected BasicNode(Builder builder) {
        super(builder);
        this.content = builder.content;
    }

    @Override
    public String toString() {
        return content;
    }

    public static class Builder extends DialogueNode.Builder {

        public String content;

        @Override
        public DialogueNode build() {
            return new BasicNode(this);
        }
    }
}
