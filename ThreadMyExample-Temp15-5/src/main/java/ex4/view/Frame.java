package ex4.view;

import ex4.controller.FrameUsersController;
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
public class Frame extends AbstractFrame {

    //JButton jbAdd;
    //int[] numberCol;
    FrameUsersController frameUsersController;
    //String numberFrame;

    /*public int[] getNumberCol() {
        return numberCol;
    }*/

    public Frame(/*int[] numberCol*/ String numberFrame) throws IOException, SQLException, ClassNotFoundException {
        super();
        //this.numberFrame = numberFrame;
        /*for(Map.Entry<String, String> item :  frameUsersController.getTableUsers().entrySet()) {
            System.out.println("Key: " + item.getKey()+ "-" + "Value: " + item.getValue());
            if (item.getValue() == "Frame1") {
                System.out.println("Нашли");
            }
        }*/

        /*for (int i = 0; i < numberCol.length; i++) {
            this.numberCol[i] = numberCol[i];
        }*/
        /*for (int i = 0; i < numberCol.length; i++) {
            System.out.println(numberCol[i]);
        }*/
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

