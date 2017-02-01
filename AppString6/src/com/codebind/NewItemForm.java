package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vladislav Gasanov on 30.01.2017.
 */
public class NewItemForm extends JFrame {

    Runnable onOkTask;
    //String name = "ttt.txt";
    String name = "vika";
    JLabel nameLabel = new JLabel("Задайте имя");
    JLabel temp = new JLabel("vika");
    JTextField nameField;
    JButton OK = new JButton("OK");
    JButton Cancel = new JButton("Cansel");

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public NewItemForm(Runnable _onOkTask) throws HeadlessException {
        //name = null;
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nameField = new JTextField(15);
        contents.add(nameLabel);
        contents.add(temp);
        contents.add(nameField);
        contents.add(OK);
        contents.add(Cancel);
        add(contents);
        setBounds(100, 100, 300, 200);

        onOkTask = _onOkTask;
        setVisible(false);

        new Thread(onOkTask).start(); // Action Listner for OK

        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run();
            }
        });

        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        System.out.println(name);
    }

    public void run() {
        try {
            Thread.sleep(500);
            setName(temp.getText());
        } catch (InterruptedException e) {
        }
    }

}
