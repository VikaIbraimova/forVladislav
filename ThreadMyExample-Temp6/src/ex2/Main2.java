package ex2;

import javax.swing.*;

/**
 * Created by vika on 08.10.16.
 */
public class Main2 {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.initOvals();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setBounds(200,200,300,300);
        myFrame.setVisible(true);
    }
}
