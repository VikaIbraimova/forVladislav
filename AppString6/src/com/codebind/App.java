package com.codebind;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileFilter;

/**
 * Created by vika on 29.01.17.
 */
public class App extends JFrame{
    private JPanel labelPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel buttonsPanel1;
    private JPanel buttonsPanel2;
    private JScrollPane leftScroll;
    private JScrollPane rightScroll;
    private JLabel leftLabel;
    private JLabel rightLabel;
    private JButton createButton;
    private JButton copyButton;
    private JButton changePlaceButton;
    private JButton deleteButton;
    private JPanel rootPanel;
    private JList leftList;
    private JList rightList;

    /*public App() throws HeadlessException {
        //Пути для меток
        File file = new File(".");
        leftLabel.setText(file.getAbsolutePath());
        rightLabel.setText(file.getAbsolutePath());

        //Дерово с папками и файлами


        setContentPane(rootPanel);
        setVisible(true);
        //setSize(360, 360);
        setBounds(100, 100, 500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }*/

    public void setLeftLabel(JLabel leftLabel) {
        File file = new File(".");
        leftLabel.setText(file.getAbsolutePath());
        this.leftLabel = leftLabel;
    }

    public JLabel getLeftLabel() {
        return leftLabel;
    }




    public void getCurrentPath(){
        //Получить текущую
        String currentDirectory;
        File file = new File(".");
        currentDirectory = file.getAbsolutePath();
        System.out.println("Current working directory : "+currentDirectory);
    }

    //StackOverflow

    public Component getGui(File[] all, boolean vertical) {
        // put File objects in the list..
       // JList fileList = new JList(all);
        leftList = new JList(all);
        // ..then use a renderer
        leftList.setCellRenderer(new FileRenderer(!vertical));

        if (!vertical) {
            leftList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
            leftList.setVisibleRowCount(-1);
        } else {
            leftList.setVisibleRowCount(9);
        }
        return new JScrollPane(leftList);
    }


    //StackOverflow



    public static void main(String[] args) {
        //new App();
        //JFrame frame = new JFrame();
        //frame.setContentPane();
        //frame.setVisible(true);
        //StackOverflow

        //StackOverflow
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                File f = new File(System.getProperty("user.home"));
                //FileList fl = new FileList();
                App fl = new App();
                //Пути для меток
                //File file = new File(".");
                //fl.leftLabel.setText(file.getAbsolutePath());
                //fl.rightLabel.setText(file.getAbsolutePath());

                Component c1 = fl.getGui(f.listFiles(new TextFileFilter()),true);

                Component c2 = fl.getGui(f.listFiles(new TextFileFilter()),false);

                Component c3 = fl.buttonsPanel1;

                Component c4 = fl.buttonsPanel2;

                Component c0 = fl.getLeftLabel();

                JFrame frame = new JFrame("File List");
                frame.setLayout(new FlowLayout());

                JPanel guiMain = new JPanel(new BorderLayout());


                JPanel gui = new JPanel(new BorderLayout());
                gui.add(c1,BorderLayout.WEST);
                gui.add(c2,BorderLayout.CENTER);
                c2.setPreferredSize(new Dimension(375,100));
                gui.setBorder(new EmptyBorder(3,3,3,3));
                gui.add(c3,BorderLayout.SOUTH);
                gui.add(c0,BorderLayout.NORTH);
                guiMain.add(gui,BorderLayout.EAST);

                //Не вставляется
                JPanel gui2 = new JPanel(new BorderLayout());
                gui2.add(c1,BorderLayout.WEST);
                gui2.add(c2,BorderLayout.CENTER);
                c2.setPreferredSize(new Dimension(375,100));
                gui2.setBorder(new EmptyBorder(3,3,3,3));
                gui2.add(c4,BorderLayout.SOUTH);
                guiMain.add(gui2,BorderLayout.WEST);

               // frame.setContentPane(guiLabel);
                frame.setContentPane(guiMain);
                //frame.setContentPane(gui);
                //frame.setContentPane(gui2);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        //StackOverflow
    }
}

class FileRenderer extends DefaultListCellRenderer {

    private boolean pad;
    private Border padBorder = new EmptyBorder(3,3,3,3);

    FileRenderer(boolean pad) {
        this.pad = pad;
    }

    @Override
    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        Component c = super.getListCellRendererComponent(
                list,value,index,isSelected,cellHasFocus);
        JLabel l = (JLabel)c;
        File f = (File)value;
        l.setText(f.getName());
        l.setIcon(FileSystemView.getFileSystemView().getSystemIcon(f));
        if (pad) {
            l.setBorder(padBorder);
        }

        return l;
    }
}

class TextFileFilter implements FileFilter {

    public boolean accept(File file) {
        // implement the logic to select files here..
        String name = file.getName().toLowerCase();
        //return name.endsWith(".java") || name.endsWith(".class");
        return name.length()<20;
    }
}
