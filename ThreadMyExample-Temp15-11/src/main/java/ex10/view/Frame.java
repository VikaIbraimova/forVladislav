package ex10.view;

import ex10.model.TableModel;
import ex10.model.TableModel2;

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

    public Frame() throws SQLException, IOException, ClassNotFoundException {
        super();
    }

    public AbstractFrame initFrame(String frameType) throws IOException, SQLException, ClassNotFoundException {
        System.out.println(frameType);

        if(frameType.equals("Frame1")) {
            System.out.println("Выбран Frame1");

        }
        if(frameType.equals("Frame2")) {
            System.out.println("Выбран Frame2");

        }
        /**
         *  Куда вынести эту реализацию, при том, что она еще не сделана вся - тоесть ее много будет??? Для одного usera
         *  доступнка одна ячейка для реадктирования, для другого другие ячейки
         */

        //Создадим модель таблицы
        TableModel2 tModel = new TableModel2(excelCellText);
        //tModel.getFrameUsers(frameType);
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
        return null;
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
