package ex4.view;

import ex4.model.TableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by vika on 21.10.16.
 */
public class Frame2 extends AbstractFrame {

    public Frame2(String numberFrame) throws IOException, SQLException, ClassNotFoundException {
        super();
        //Создадим модель таблицы
        TableModel tModel = new TableModel(humans);
        tModel.getFrameUsers(numberFrame);
        //-----------Добавление сформированной модели на форму, окончательное отображение формы-------
        //На основе модели, создадим новую JTable
        jTabPeople = new JTable(tModel);
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(jTabPeople);
        //Устаналиваем размеры прокручиваемой области
        jTabPeople.setPreferredScrollableViewportSize(new Dimension(200, 100));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        //jfrm.getContentPane().add(jscrlp);
        //jfrm.setVisible(true);
        add(jscrlp);
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
        System.out.println("Кнопка Add нажата в Frame2");
    }

    @Override
    public void clickDelete() {
        System.out.println("Кнопка Delete нажата в Frame2");
    }

    @Override
    public void clickEdit() {
        super.clickEdit();
        System.out.println("Кнопка Edit нажата в Frame2");
    }
}