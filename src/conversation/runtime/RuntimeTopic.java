/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.runtime;

import conversation.core.Topic;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class RuntimeTopic {

    private Topic topic;
// the beats in the topic so far
    private List<RuntimeBeat> beats = new ArrayList<RuntimeBeat>();

    public RuntimeTopic(Topic topic) {
        this.topic = topic;
    }

    public Topic getTopic() {
        return topic;
    }

    public List<RuntimeBeat> getBeats() {
        return beats;
    }

    public void addBeat(RuntimeBeat beat) {
        beats.add(beat);
    }
}
