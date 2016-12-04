package ex19.view;

import ex19.model.TableModel2;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by vika on 21.10.16.
 */
public class Frame extends AbstractFrame {
    //Номер строки по которой щелкнули мышкой
    int selIndex = 0;
    //Номер столбца ...
    int selIndex2 = 0;

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
        //---------------------
        final JLabel currentSelectionLabel = new JLabel("Vika");
        currentSelectionLabel.setAutoscrolls(true);
        add(currentSelectionLabel);
        //---------------------
        //Создадим модель таблицы
        //TableModel3 tModel = new TableModel3(excelCellText);
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
        //------------------------Реагируем на щелчок мыши по таблице
        ListSelectionModel selModel = jTabPeople.getSelectionModel();
        selModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                TableModel2 tModel2 = (TableModel2)jTabPeople.getModel();
                String result = "";
                int[] selectedRows = jTabPeople.getSelectedRows();
                int[] vColIndices = jTabPeople.getSelectedColumns();
                for(int i = 0; i < selectedRows.length; i++) {
                    selIndex = selectedRows[i];
                    for (int j = 0; j < vColIndices.length; j++) {
                        selIndex2 = vColIndices[j];
                        TableModel2 tModel3 = (TableModel2) jTabPeople.getModel();
                        Object value = tModel3.getValueAt(selIndex,selIndex2);
                        result = result + value;
                        if(i != vColIndices.length - 1) {
                            result += ", ";
                        }
                    }
                }
                currentSelectionLabel.setText(result);
                System.out.println("Номер строки: " + selIndex + "Номер столбца: " + selIndex2);
            }
        });
        //------------------------
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