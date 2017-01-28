package ru.test.filemanager2;

import java.awt.*;

import javax.swing.*;


/**
 * Created by vika on 28.01.17.
 */
public class MyFrame2 extends JFrame {

    JPanel leftPanel;
    JPanel rightPanel;
    JLabel pathPanelLeft;
    JLabel pathPanelRight;

    public MyFrame2() throws HeadlessException {
        setTitle("My TotalCommander");
        getContentPane().setLayout(new GridLayout(2,2));
        setBounds(100, 100, 300, 200);

        leftPanel = new JPanel();
        pathPanelLeft = new JLabel("Left_panel");
        setContentPane(leftPanel);



        pathPanelRight = new JLabel("Right_panel");

        leftPanel.add(pathPanelLeft);
        rightPanel = new JPanel();
        rightPanel.add(pathPanelRight);

        setContentPane(rightPanel);


        // Создание строки главного меню
        ///JMenuBar menuBar = new JMenuBar();
        // Добавление в главное меню выпадающих пунктов меню
        //menuBar.add(createFileMenu());
        //menuBar.add(createViewMenu());
        // Подключаем меню к интерфейсу приложения
        ///setJMenuBar(menuBar);
        // Открытие окна

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
