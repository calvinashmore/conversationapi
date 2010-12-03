/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.ui;

import conversation.core.Conversation;
import conversation.core.DialogueBeat;
import conversation.core.DialogueNode;
import conversation.core.Topic;
import conversation.parser.Parser;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Calvin
 */
public class MainPanel extends JPanel {

    public static void main(String args[]) throws Exception {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel panel = new MainPanel();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);


        Parser parser = new Parser(new FileInputStream("src/test.conversation"));
        Conversation conversation = parser.ConversationTopLevel();
        panel.runConversation(conversation);
    }
    private JTextArea output;
    private JList selections;
    private JTextArea selectionInfo;
    private Conversation conversation;
    final private Selector selector;
    private DialogueNode selection;
    private conversation.runtime.Runtime runtime;

    public MainPanel() {

        setLayout(new BorderLayout());

        output = new JTextArea(20, 50);
        add(output, BorderLayout.CENTER);

        JPanel subPanel2 = new JPanel();
        subPanel2.setLayout(new BorderLayout());

        JPanel subPanel1 = new JPanel();
        selections = new JList();
        selections.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                selectionChanged();
            }
        });
        subPanel1.add(selections);
        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                onSelect();
            }
        });
        subPanel1.add(selectButton);

        subPanel2.add(subPanel1, BorderLayout.NORTH);

        selectionInfo = new JTextArea(4, 50);
        subPanel2.add(selectionInfo, BorderLayout.CENTER);


        add(subPanel2, BorderLayout.SOUTH);

        selector = new Selector();
    }

    private class Selector implements conversation.runtime.Runtime.RuntimeSelector {

        public DialogueNode choose(List<DialogueNode> choices) {
            selections.setModel(new DefaultComboBoxModel(choices.toArray()));
            selections.setSelectedIndex(0);
            selection = null;
            synchronized (this) {
                while (selection == null) {
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return selection;
        }
    }

    private class ConversationLogger implements conversation.runtime.Runtime.Listener {

        public void onNewNode(DialogueNode node) {
            output.append("new node: " + (node).getAttributes() + "\n");
        }

        public void onNewBeat(DialogueBeat beat) {
            output.append("new beat: " + beat.getLabel() + "\n");
        }

        public void onNewTopic(Topic topic) {
            output.append("new topic: " + topic.getLabel() + "\n");
        }
    }

    public void runConversation(Conversation c) {
        this.conversation = c;
        runtime = new conversation.runtime.Runtime(conversation);
        output.append("Starting new conversation: " + c.getLabel() + "\n");
        runtime.setListener(new ConversationLogger());
        runtime.startConversation();
        while (runtime.step(selector)) {
        }
        output.append("Conversation end");
        selections.setModel(new DefaultComboBoxModel());
    }

    private void selectionChanged() {
        DialogueNode selectedItem = (DialogueNode) selections.getSelectedValue();

        if (selectedItem == null) {
            selectionInfo.setText("No selection");
        } else {
            selectionInfo.setText(selectedItem.getAttributes().toString());
        }
    }

    private void onSelect() {
        synchronized (selector) {
            selection = (DialogueNode) selections.getSelectedValue();
            selector.notify();
        }
    }
}
