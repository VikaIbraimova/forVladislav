package ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by vika on 31.10.16.
 */
public class MyFrameView extends JFrame {
    private JTextField text = new JTextField(10);
    private JLabel addLabel = new JLabel("Vika");
    private JButton changeButton = new JButton("Change_Label");

    public MyFrameView() throws HeadlessException {
        JPanel calcPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,200);

        calcPanel.add(text);
        calcPanel.add(addLabel);
        calcPanel.add(changeButton);
        this.add(calcPanel);
    }

    public String getText(){
        return text.getText();
    }

    public void setTextLabel(String s){
        addLabel.setText(s);
        text.setText("");
    }

    void addMyFrameListener(ActionListener listenerClickButton){
        changeButton.addActionListener(listenerClickButton);
    }
}
