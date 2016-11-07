package ex6.view;

import ex6.controller.FrameUsersController;
import ex6.model.TableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by vika on 21.10.16.
 */
public class Frame extends AbstractFrame {
    public Frame(String numberFrame) throws IOException, SQLException, ClassNotFoundException {
        super();
        //Создадим модель таблицы
        TableModel tModel = new TableModel(excelCellText);
        tModel.getFrameUsers(numberFrame);
        //-----------Добавление сформированной модели на форму, окончательное отображение формы-------
        //На основе модели, создадим новую JTable
        jTabPeople = new JTable(tModel);
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(jTabPeople);
        //Устаналиваем размеры прокручиваемой области
        jTabPeople.setPreferredScrollableViewportSize(new Dimension(200, 100));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        add(jscrlp);
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
        jbDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickDelete();
            }
        });
    }

    @Override
    public void clickAdd() {
        System.out.println("Кнопка Add нажата в Frame");
    }

    @Override
    public void clickDelete() {
        System.out.println("Кнопка Delete нажата в Frame");
    }

    @Override
    public void clickEdit() {
        System.out.println("Кнопка Edit нажата в Frame");
    }
}
