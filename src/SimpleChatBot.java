import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleChatBot extends JFrame implements ActionListener {

    final String TITLE_OF_PROGRAM = "Chatter: simple chatbot";
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;

    JTextArea dialogue;
    JCheckBox ai;
    JTextField message;
    SimpleBot sbot;

    public SimpleChatBot(){
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);

        dialogue = new JTextArea();
        dialogue.setLineWrap(true); //перенос строк на новые строки
        dialogue.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(dialogue);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        ai = new JCheckBox("AI");
        //ai.doClick();
        message = new JTextField();
        message.addActionListener(this);
        JButton enter = new JButton("Enter");
        enter.addActionListener(this);
        buttonPanel.add(ai);
        buttonPanel.add(message);
        buttonPanel.add(enter);
        add(BorderLayout.SOUTH, buttonPanel);
        add(BorderLayout.CENTER, scrollPane);
        setVisible(true);

        sbot = new SimpleBot();

    }


    public static void main(String[] args) {
        new SimpleChatBot();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (message.getText().trim().length() > 0) {
            dialogue.append(message.getText() + "\n");
            dialogue.append(TITLE_OF_PROGRAM.substring(0, 9) +
                    sbot.sayInReturn(message.getText(), ai.isSelected()) + "\n");
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}
/*
 try{
                StyledDocument doc = dialogue.getStyledDocument();
                doc.insertString(doc.getLength(),
                        TITLE_OF_PROGRAM.substring(0, 9) +
                        sbot.sayInReturn(message.getText(), ai.isSelected()) + "\n",
                        botStyle);
            }catch (Exception exception){
                exception.printStackTrace();
            }
 */