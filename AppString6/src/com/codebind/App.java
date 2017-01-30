package com.codebind;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/**
 * Created by vika on 29.01.17.
 */
public class App extends JFrame{

    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel btnLetfPanel;
    private JPanel btnRightPanel;
    private JScrollPane leftScroll;
    private JScrollPane rightScroll;
    private JLabel leftLabelPath;
    private JLabel rightLabelPath;
    private JButton createButton;
    private JButton copyButton;
    private JButton moveButton;
    private JButton deleteButton;
  //  private JPanel rootPanel;
    private JList leftList;
    private JList rightList;
    private static App instance;

    private java.util.List selectedItems = new ArrayList<>();


    /*public App() throws HeadlessException {
        //Пути для меток
        File file = new File(".");
        leftLabelPath.setText(file.getAbsolutePath());
        rightLabelPath.setText(file.getAbsolutePath());

        //Дерово с папками и файлами


        setContentPane(rootPanel);
        setVisible(true);
        //setSize(360, 360);
        setBounds(100, 100, 500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }*/

    public App() throws HeadlessException {
        setTitle("Total Commander");
        leftPanel = new JPanel(new BorderLayout());
        rightPanel = new JPanel(new BorderLayout());
        btnLetfPanel = new JPanel(new FlowLayout());
        btnRightPanel = new JPanel(new FlowLayout());
        leftScroll = new JScrollPane();
        rightScroll = new JScrollPane();
        leftLabelPath = new JLabel("path undefined left");
        rightLabelPath = new JLabel("path undefined rigth");
        createButton = new JButton("Create");
        copyButton = new JButton("Copy");
        moveButton = new JButton("Move");
        deleteButton = new JButton("Delete");
//        leftList = new JList<File>();
//        rightList = new JList();

//        leftPanel
//                leftLabelPath
//                leftScroll
//                    leftList
//                btnLetfPanel
//                    createButton
//                    copyButton

        copyButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onCopy();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDelete();
            }
        });



        btnLetfPanel.add(createButton);
        btnLetfPanel.add(copyButton);
//        leftScroll.add(leftList);
        leftPanel.add(leftLabelPath, BorderLayout.NORTH);
//        leftPanel.add(leftScroll, BorderLayout.CENTER);
        leftPanel.add(btnLetfPanel, BorderLayout.SOUTH);

        btnRightPanel.add(moveButton);
        btnRightPanel.add(deleteButton);
//        rightScroll.add(rightList);
        rightPanel.add(rightLabelPath, BorderLayout.NORTH);
//        rightPanel.add(rightScroll, BorderLayout.CENTER);
        rightPanel.add(btnRightPanel, BorderLayout.SOUTH);

        setLayout(new GridLayout(1,2));
        add(leftPanel);
        add(rightPanel);
        setSize(400, 400);
        setVisible(true);

        //setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static App getInstnce(){
        if (instance == null ) {
            instance = new App();
        }
        return instance;
    }

    public void start() throws HeadlessException {
        File f = new File(System.getProperty("user.home"));
        leftLabelPath.setText(f.getAbsolutePath());
        rightLabelPath.setText(f.getAbsolutePath());

        leftScroll = ((JScrollPane) getGui(f.listFiles(new TextFileFilter()), true, true));
        rightScroll = ((JScrollPane) getGui(f.listFiles(new TextFileFilter()), false, false));

        leftPanel.add(leftScroll, BorderLayout.CENTER);
        leftPanel.revalidate();
        leftPanel.repaint();

        rightPanel.add(rightScroll, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();

        pack();

    }

    public void setLeftLabelPath(JLabel leftLabelPath) {
        File file = new File(".");
        leftLabelPath.setText(file.getAbsolutePath());
        this.leftLabelPath = leftLabelPath;
    }

    public JLabel getLeftLabelPath() {
        return leftLabelPath;
    }

    public JLabel getRightLabelPath() {
        return rightLabelPath;
    }

    public void setRightLabelPath(JLabel rightLabelPath) {
        File file = new File(".");
        leftLabelPath.setText(file.getAbsolutePath());
        this.rightLabelPath = rightLabelPath;
    }

    public void getCurrentPath(){
        //Получить текущую
        String currentDirectory;
        File file = new File(".");
        currentDirectory = file.getAbsolutePath();
        System.out.println("Current working directory : "+currentDirectory);
    }

    //StackOverflow


    public void setLeftList(JList leftList) {
        this.leftList = leftList;
    }

    public void setRightList(JList rightList) {
        this.rightList = rightList;
    }

    public Component getGui(File[] all, boolean vertical, boolean isLeft) {
        // put File objects in the list..
        // JList fileList = new JList(all);
        JList fileList = new JList(all);
        // ..then use a renderer
        fileList.setCellRenderer(new FileRenderer(!vertical));

        if (!vertical) {
            fileList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
            fileList.setVisibleRowCount(-1);
        } else {
            fileList.setVisibleRowCount(9);
        }
        if (isLeft) {
            setLeftList(fileList);
        } else {
            setRightList(fileList);
        }
        return new JScrollPane(fileList);
    }


    //StackOverflow


    public void onCopy() {
        File f = (File) leftList.getSelectedValue();
        System.out.println(f.getAbsoluteFile());
        System.out.println(Files.isDirectory(f.toPath()));
    }

/*    public void onCopy() {
        File f = (File) leftList.getSelectedValue();
        File[] children = f.listFiles();
        if (children != null) {
            for (int i = 0; i < children.length; i++) {
                System.out.println(children);
                //JLabel label = new JLabel(children[i].getName());
                //rootContent.add(label);
            }
        }
        System.out.println(f.getAbsoluteFile());
        System.out.println(Files.isDirectory(f.toPath()));
    }*/

    public void onDelete(){
        File f = (File) leftList.getSelectedValue();
        f.delete();
    }

    public void onCreateFile() throws IOException {
        String currentDirectory;
        File file = new File(".");
        currentDirectory = file.getAbsolutePath();
        System.out.println("Current working directory : "+currentDirectory);
        file.createNewFile();

        //---------------------------------
        // получаем разделитель пути в текущей операционной системе
        String fileSeparator = System.getProperty("file.separator");

        //создаем абсолютный путь к файлу
        String absoluteFilePath = fileSeparator + "Users" + fileSeparator + "prologistic" + fileSeparator + "file.txt";

        File file = new File(absoluteFilePath);
        if(file.createNewFile()){
            System.out.println(absoluteFilePath + " Файл создан");
        } else {
            System.out.println("Файл " + absoluteFilePath + " уже существует");
            //создаем файл только с указанием имени файла
            file = new File("file.txt");
            if(file.createNewFile()){
                System.out.println("file.txt файл создан в корневой директории проекта");
            }else System.out.println("file.txt файл уже существует в корневой директории проекта");

            //создаем файл с указанием относительного пути к файлу
            String relativePath = "tmp" + fileSeparator + "file.txt";
            file = new File(relativePath);
            if(file.createNewFile()){
                System.out.println(relativePath + " файл создан в корневой директории проекта");
            }else System.out.println("Файл " + relativePath + " уже существует в директории проекта");

            //---------------------------------
    }

    public void onCreateDirInCurrentDir() throws IOException {
        String currentDirectory;
        File file = new File(".");
        currentDirectory = file.getAbsolutePath();
        System.out.println("Current working directory : "+currentDirectory);
        File newFile = new File(file.getAbsolutePath());
        boolean created = newFile.createNewFile();
        if(created)
            System.out.println("Файл создан");
    }

    public static void main(String[] args) {
        App.getInstnce().start();
    }
}




