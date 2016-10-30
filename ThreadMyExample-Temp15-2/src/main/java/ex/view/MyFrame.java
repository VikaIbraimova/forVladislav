package ex.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by vika on 21.10.16.
 */
public class MyFrame extends MyAbstractFrame {

    //JButton jbAdd;

    public MyFrame() throws IOException {
        super();
        //super();
        //JFrame jfrm = new JFrame("JTableExample5");
        //Устанавливаем диспетчер компоновки
        //jfrm.getContentPane().setLayout(new FlowLayout());
        //Устанавливаем размер окна
        //jfrm.setSize(400, 200);
        //frame.getContentPane().setLayout(new FlowLayout());
        //this.btnPress = new JButton("Add");
        //jfrm.add(btnPress);
        //add(btnPress);
        //jbAdd = new JButton("Add");
        //add(jbAdd);
        jbAdd.setText("Add_One");
        jbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Кнопка Add нажата в MyFrame");
                clickAdd();
            }
        });
        jbEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickEdit();
            }
        });
        jbDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickDelete();
            }
        });
    }

    @Override
    public void clickAdd() {
        System.out.println("Кнопка Add нажата в MyFrame");
    }

    @Override
    public void clickDelete() {
        System.out.println("Кнопка Delete нажата в MyFrame");
    }

    @Override
    public void clickEdit() {
        //super.clickEdit();
        System.out.println("Кнопка Edit нажата в MyFrame");
    }
}
