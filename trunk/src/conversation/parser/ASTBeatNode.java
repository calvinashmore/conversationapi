/* Generated By:JJTree: Do not edit this line. ASTBeatNode.java */
package conversation.parser;

public class ASTBeatNode extends ParseNode {

    private ASTGroupNode root;
    private boolean starting;

    public ASTGroupNode getRoot() {
        return root;
    }

    public void setRoot(ASTGroupNode root) {
        this.root = root;
    }

    public boolean isStarting() {
        return starting;
    }

    public void setStarting(boolean starting) {
        this.starting = starting;
    }



    public ASTBeatNode(int id) {
        super(id);
    }

    public ASTBeatNode(Parser p, int id) {
        super(p, id);
    }
}
