package ex.view;

import ex.model.Data;
import ex.model.TableFrameModel;
import ex.model.TableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vika on 21.10.16.
 */
public class Frame extends AbstractFrame {
    int i1;

    public int getI1() {
        return i1;
    }

    //ArrayList humansUpdate = new ArrayList<String>();
    public Frame(int i1) throws IOException {
        super();
        this.i1 = i1;
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
                myData4.setCol2(myListResult.get(i));
                i++;
                //myData4.setCol3(myListResult.get(i));
                //k++;
                //i++;
            }
            humans.add(myData4);
        }
        //Обход таблицы Excel
        //Iterator iter = myListResult.iterator();
        //for (int i = 0; iter.hasNext(); i++) {
        //        System.out.println(iter.next().toString() + "k = " + k);
        //}

        //Создадим модель таблицы
        TableFrameModel tModel = new TableFrameModel(humans);
        //-----------Добавление сформированной модели на форму, окончательное отображение формы-------
        //На основе модели, создадим новую JTable
        jTabPeople = new JTable(tModel);
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(jTabPeople);
        //Устаналиваем размеры прокручиваемой области
        jTabPeople.setPreferredScrollableViewportSize(new Dimension(200, 100));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        add(jscrlp);

        //-----------Добавление сформированной модели на форму-------
        jbAdd.setText("Add_One");
        jbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Кнопка Add нажата в Frame");
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
        //super.clickEdit();
        System.out.println("Кнопка Edit нажата в Frame");
    }
}

