package ru.test.filemanager2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vika on 28.01.17.
 */
public class MyFrame extends JFrame {
    public MyFrame() throws HeadlessException {
        setTitle("My TotalCommander");
        getContentPane().setLayout(new FlowLayout());
        //this.jbAdd = new JButton("Add");
        //add(jbAdd);
        //this.jbDelete = new JButton("Delete");
        //add(jbDelete);
        //this.jbEdit = new JButton("Edit");
        //add(jbEdit);
        setBounds(100, 100, 300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*public void getFrame(){
        JFrame myWindow = new JFrame("My TotalCommander");
        myWindow.getDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}
