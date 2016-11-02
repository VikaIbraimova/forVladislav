package ex.view;


import ex.controller.FrameUsersController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by vika on 22.10.16.
 */
public class MainFrame extends JFrame{
    //BdUsers bdUsers;
    FrameUsersController fUsers;
    //Для отображения инфы о входе пользователя
    JLabel jLabel;
    //Поля для ввода логина и пароля
    TextField textField;
    TextField textField2;
    public MainFrame() throws SQLException, ClassNotFoundException, IOException {
        //bdUsers = new BdUsers();
        fUsers = new FrameUsersController();
        JPanel jPanel = new JPanel();
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new BorderLayout());
        jPanel.setLayout(new FlowLayout());
        add(jPanel);
        add(jPanel1);
        setTitle("Working with Excel");
        getContentPane().setLayout(new FlowLayout());
        jLabel = new JLabel("Для отображения Excel введите правильно свои логин и пароль");
        jPanel1.add(jLabel,BorderLayout.NORTH);
        textField = new TextField(10);
        jPanel.add(textField);
        textField2 = new TextField(10);
        jPanel.add(textField2);
        Button sayHelloBtn = new Button("OK");
        jPanel.add(sayHelloBtn);
        sayHelloBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //textField.setText(e.getActionCommand());
                jLabel.setText("");
                //Boolean log = bdUsers.getUserLogPass().containsKey(textField.getText());
                //Boolean pass = bdUsers.getUserLogPass().containsValue(textField2.getText());
                boolean log = fUsers.getUserLogPass().containsKey(textField.getText());
                boolean pass = fUsers.getUserLogPass().containsValue(textField2.getText());
                if (log && pass) {
                    jLabel.setText("Логин и Пароль введены верно");
                    //String tableUser = bdUsers.getTableUsers().get(textField.getText());
                    String tableUser = fUsers.getTableUsers().get(textField.getText());
                    //FrameSelector fs = new FrameSelector();
                    try {
                        //AbstractFrame maf = fs.getFrame(tableUser);
                        AbstractFrame maf = FrameSelector.getInstance().getFrame(tableUser);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    jLabel.setText("Неверный логин и/или пароль");
                }
            }
        });
        setBounds(100, 100, 500, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
