/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation.ui;

import conversation.core.Conversation;
import conversation.core.DialogueBeat;
import conversation.core.DialogueNode;
import conversation.core.Topic;
import conversation.parser.ParseException;
import conversation.parser.Parser;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Calvin
 */
public class MainPanel extends JPanel {

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final MainPanel panel = new MainPanel();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        JMenuBar menu = new JMenuBar();
        JMenuItem openCommand = new JMenuItem("Open");
        openCommand.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                handleOpen(panel);
            }
        });
        menu.add(openCommand);
        frame.setJMenuBar(menu);


//        Parser parser = new Parser(new FileInputStream("src/test.conversation"));
//        Conversation conversation = parser.ConversationTopLevel();
//        panel.runConversation(conversation);
    }
    private JTextArea output;
    private JList selections;
    private JTextArea selectionInfo;
    private Conversation conversation;
    final private Selector selector;
    private DialogueNode selection;
    private conversation.runtime.Runtime runtime;

    private static void handleOpen(MainPanel parent) {

        if (parent.runtime != null) {
            // do not continue if we are already running.
            return;
        }

        JFileChooser fc = new JFileChooser();
        String curDir = System.getProperty("user.dir");
        fc.setCurrentDirectory(new File(curDir));
        fc.showOpenDialog(parent);

        File selectedFile = fc.getSelectedFile();
        if (selectedFile == null) {
            return;
        }

        try {
            Parser parser = new Parser(new FileInputStream(selectedFile));
            Conversation conversation = parser.ConversationTopLevel();

            parent.runConversation(conversation);

        } catch (FileNotFoundException ex) {
            parent.output.append("Could not find file\n");
        } catch (ParseException ex) {
            parent.output.append("Error parsing file\n");
            parent.output.append("message: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        }
    }

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
        Runnable r = new Runnable() {

            public void run() {
                while (runtime.step(selector)) {
                }
                output.append("Conversation end");
                selections.setModel(new DefaultComboBoxModel());
                runtime = null;
            }
        };

        new Thread(r).start();
    }

    private void selectionChanged() {
        DialogueNode selectedItem = (DialogueNode) selections.getSelectedValue();

        if (selectedItem == null) {
            selectionInfo.setText("No selection");
        } else {
            String text = selectedItem.getAttributes().toString() + "\n";
            if (selectedItem.getBeat() != runtime.getCurrentBeat().getBeat()) {
                text += "new beat\n";
                if (selectedItem.getBeat().getTopic() != runtime.getCurrentTopic().getTopic()) {
                    text += "new topic\n";
                }
            }

            selectionInfo.setText(text);
        }
    }

    private void onSelect() {
        synchronized (selector) {
            selection = (DialogueNode) selections.getSelectedValue();
            selector.notify();
        }
    }
}
