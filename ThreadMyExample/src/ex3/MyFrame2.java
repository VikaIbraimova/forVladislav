package ex3;


import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by vika on 21.10.16.
 */
public class MyFrame2 extends MyAbstractFrame {

    public MyFrame2() throws IOException {
        super();
        jbDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickDelete();
            }
        });
        jbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickAdd();
            }
        });
        jbEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickEdit();
            }
        });
    }

    @Override
    public void clickAdd() {
        System.out.println("Кнопка Add нажата в MyFrame2");
    }

    @Override
    public void clickDelete() {
        System.out.println("Кнопка Delete нажата в MyFrame2");
    }

    @Override
    public void clickEdit() {
        super.clickEdit();
        System.out.println("Кнопка Edit нажата в MyFrame2");
    }
}
