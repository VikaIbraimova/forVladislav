package ex.view;

import ex.model.Data;
import ex.model.TableFrame2Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by vika on 21.10.16.
 */
public class Frame2 extends AbstractFrame {

    public Frame2() throws IOException {
        super();
        ArrayList humans = new ArrayList<String>();
        Data myData4;
        for (int i = 3; i < 12; i++) {
            myData4 = new Data();
            // int k = 1;
            if (/*i == 0 ||*/ i == 3 || i == 6 || i == 9) {
                // if (k == i1) {
                //myData4.setCol1("null");
                //i++;
                // } else {
                myData4.setCol1(myListResult.get(i));
                i++;
                // }
                //myData4.setCol2(myListResult.get(i));
                //i++;
                myData4.setCol3(myListResult.get(i+1));
                //k++;
                i++;
            }
            humans.add(myData4);
        }
        //Обход таблицы Excel
        //Iterator iter = myListResult.iterator();
        //for (int i = 0; iter.hasNext(); i++) {
        //        System.out.println(iter.next().toString() + "k = " + k);
        //}

        //Создадим модель таблицы
        TableFrame2Model tModel2 = new TableFrame2Model(humans);
        //-----------Добавление сформированной модели на форму, окончательное отображение формы-------
        //На основе модели, создадим новую JTable
        jTabPeople = new JTable(tModel2);
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(jTabPeople);
        //Устаналиваем размеры прокручиваемой области
        jTabPeople.setPreferredScrollableViewportSize(new Dimension(200, 100));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
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