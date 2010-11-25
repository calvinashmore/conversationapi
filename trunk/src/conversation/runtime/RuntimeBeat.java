/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.runtime;

import conversation.core.DialogueBeat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class RuntimeBeat {

    private DialogueBeat beat;
    // the nodes in the beat so far.
    private List<RuntimeNode> nodes = new ArrayList<RuntimeNode>();

    public RuntimeBeat(DialogueBeat beat) {
        this.beat = beat;
    }

    public DialogueBeat getBeat() {
        return beat;
    }

    public List<RuntimeNode> getNodes() {
        return nodes;
    }

    public void addNode(RuntimeNode node) {
        nodes.add(node);
    }
}
