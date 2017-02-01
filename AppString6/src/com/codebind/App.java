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
import java.nio.file.Path;
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
    private NewItemForm form;

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

        copyButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onCopy();
            }
        });

        createButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onCreate();
            }
        });

        deleteButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onDelete();
            }
        });



        btnLetfPanel.add(createButton);
        btnLetfPanel.add(copyButton);
        leftPanel.add(leftLabelPath, BorderLayout.NORTH);
        leftPanel.add(btnLetfPanel, BorderLayout.SOUTH);

        btnRightPanel.add(moveButton);
        btnRightPanel.add(deleteButton);
        rightPanel.add(rightLabelPath, BorderLayout.NORTH);
        rightPanel.add(btnRightPanel, BorderLayout.SOUTH);

        setLayout(new GridLayout(1,2));
        add(leftPanel);
        add(rightPanel);
        setSize(400, 400);
        setVisible(true);
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

    public void setLeftList(JList leftList) {
        this.leftList = leftList;
    }

    public void setRightList(JList rightList) {
        this.rightList = rightList;
    }

    public Component getGui(File[] all, boolean vertical, boolean isLeft) {
        // put File objects in the list..
        // JList fileList = new JList(all);

        // FIXME: 31.01.2017 add parent folder aka ".."

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
        fileList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                onListClick(fileList, isLeft);
            }
        });
        return new JScrollPane(fileList);
    }

    private void onListClick(JList list, boolean isLeft) {

        File f = ((File) list.getSelectedValue());
        if (Files.isDirectory(f.toPath())) {
            if (isLeft) {
                leftLabelPath.setText(f.getAbsolutePath());

                leftPanel.remove(leftScroll);

                leftScroll = ((JScrollPane) getGui(f.listFiles(new TextFileFilter()), true, true));
                // FIXME: 31.01.2017 Reload Lists

                leftPanel.add(leftScroll, BorderLayout.CENTER);
                leftPanel.revalidate();
                leftPanel.repaint();


            } else {
                rightLabelPath.setText(f.getAbsolutePath());

                rightPanel.remove(rightScroll);

                rightScroll = ((JScrollPane) getGui(f.listFiles(new TextFileFilter()), false, false));
                // FIXME: 31.01.2017 Reload Lists

                rightPanel.add(rightScroll, BorderLayout.CENTER);
                rightPanel.revalidate();
                rightPanel.repaint();
            }
            pack();
        } else {
            System.out.println("ERROR: This is not directory!!!" + isLeft);
        }
    }

    public void onCopy() {
        File f = (File) leftList.getSelectedValue();
        System.out.println(f.getAbsoluteFile());
        System.out.println(Files.isDirectory(f.toPath()));
    }

    public void onDelete(){
        File[] files = ((File[]) leftList.getSelectedValues());
        onDelete(files);
    }
    public void onDelete(File[] files){
        form = new NewItemForm(new Runnable() {
            @Override
            public void run() {

                try {
                    Files.delete(new File(leftLabelPath.getText() + File.separator + form.name).toPath());
                    // FIXME: 31.01.2017 Reload Lists

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        form.setVisible(true);

    }

    public void onCreate(){
        form = new NewItemForm(new Runnable() {
            @Override
            public void run() {

                try {
                    //System.out.println(leftLabelPath.getText() + File.separator + form.name);
                    //Files.createFile(new File(leftLabelPath.getText() + File.separator + form.name).toPath());
                    Files.createFile(new File(leftLabelPath.getText() + File.separator + form.getName()).toPath());
                    // FIXME: 31.01.2017 Reload Lists

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        form.setVisible(true);
    }

    public static void main(String[] args) {
        App.getInstnce().start();
    }
}




