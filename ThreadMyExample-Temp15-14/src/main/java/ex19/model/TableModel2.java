package ex19.model;


import ex19.view.Frame;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Данный класс откат к версии, когда для любого пользователя показываются все столбцы
 */
public class TableModel2 extends AbstractTableModel {
    //ArrayList<Human> humans;
    ArrayList<Data> myDatas;
    Frame frame;

   /* TableModel(ArrayList<Human> humans) {
        super();
        this.humans = humans;
    }*/

    public TableModel2(ArrayList<Data> myDatas) {
        super();
        this.myDatas = myDatas;
    }

    @Override
    public int getRowCount() {
        //return humans.size();
        return myDatas.size();
    }
    @Override
    public int getColumnCount() {
        return 3;
        //return 3 - frame.getI1();
    }
    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                //return humans.get(r).getName();
                /*if (myDatas.get(r).getCol1()!= "null") {
                    return myDatas.get(r).getCol1();
                }*/
                return myDatas.get(r).getCol1();

            case 1:
                //return humans.get(r).getSurname();
                return myDatas.get(r).getCol2();
            case 2:
                //return humans.get(r).getTelephone();
                return myDatas.get(r).getCol3();
            default:
                return "";
        }
    }
    @Override
    public String getColumnName(int c) {
        String result = "";
        switch (c) {
            case 0:
                //result = "Name";
                result = "Фирма";
                break;
            case 1:
                //result = "Surname";
                result = "Доход";
                break;
            case 2:
                //result = "Telephone";
                result = "ГодовойДоход";
                break;
        }
        return result;
    }
}
