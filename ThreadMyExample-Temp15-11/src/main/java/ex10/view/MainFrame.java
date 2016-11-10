package ex10.view;


import ex10.controller.FrameUsersController;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
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
    //TextField textField2;
    JPasswordField textField2;
    //Если пользователь ввел верно логин и пароль, то сохраняем форму, которая ему положена
    String tableUser;

    public String getNameUser() {
        return tableUser;
    }

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
        //Логин
        textField = new TextField(10);
        jPanel.add(textField);
        //Пароль
        //textField2 = new TextField(10);
        textField2 = new JPasswordField(10);
        jPanel.add(textField2);
        Button sayHelloBtn = new Button("OK");
        jPanel.add(sayHelloBtn);
        sayHelloBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Обработка полей для ввода логина и пароля
                if (textField.getText().length() != 0) {
                    System.out.println("Кнопка нажата.Поле для логина заполнено");
                } else System.out.println("Кнопка нажата.Поле для логина не заполнено");
                //if (textField2.getText().length() != 0) {
                if (textField2.getPassword().length != 0) {
                    System.out.println("Кнопка нажата.Поле для пароля заполнено");
                } else System.out.println("Кнопка нажата.Поле для пароля не заполнено");
                //Проверка введеных данных с данными файла
                jLabel.setText("");
                boolean log = fUsers.getUserLogPass().containsKey(textField.getText());
                boolean pass = fUsers.getUserLogPass().containsValue(textField2.getText());
                if (log && pass) {
                    jLabel.setText("Логин и Пароль введены верно");
                    tableUser = fUsers.getTableUsers().get(textField.getText());
                    try {
                        AbstractFrame maf = FrameSelector.getInstance().getFrame(tableUser);
                        //AbstractFrame maf = FrameSelector.getInstance().getFrame("Frame1");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
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