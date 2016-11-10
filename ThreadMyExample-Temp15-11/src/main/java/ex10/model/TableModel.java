package ex10.model;

import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {
    ArrayList<Data> objectsData;
    String nameFrame;

    public TableModel(ArrayList<Data> objectsData) throws IOException {
        super();
        this.objectsData = objectsData;
    }

    @Override
    public int getRowCount() {
        return objectsData.size();
    }
    @Override
    public int getColumnCount() {
        if (nameFrame != null) {
            return 2;
        }
        return 3;
    }


    @Override
    public Object getValueAt(int r, int c) {
        String frame = nameFrame;
        if (frame.equals("Frame1")) {
            switch (c) {
                case 0:
                    return objectsData.get(r).getCol1();
                case 1:
                    return objectsData.get(r).getCol2();
                default:
                    return "";
            }
        }
        if (frame.equals("Frame2")) {
            switch (c) {
                case 0:
                    return objectsData.get(r).getCol1();
                case 1:
                    return objectsData.get(r).getCol3();
                default:
                    return "";
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int c) {
        String frame = nameFrame;
        String result = "";
        if (frame.equals("Frame1")) {
            switch (c) {
                case 0:
                    result = "Фирма";
                    break;
                case 1:
                    result = "Доход";
                    break;
            }
            return result;
        }
        if (frame.equals("Frame2")) {
            switch (c) {
                case 0:
                    result = "Фирма";
                    break;
                case 1:
                    result = "ГодовойДоход";
                    break;
            }
            return result;
        }
        return null;
    }

    /**
     * Из конструкторов классов-наследников класса AbstractFrame полуает, как входной параметр, имя формы.
     * Этот парметр опреляет какие столбцы таблицы Excel отображать на форме - bcgjkmpetncz в функциях
     * getColumnName(..),getValueAt(..),getColumnCount(..)
     * @param frame
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void getFrameUsers(String frame) throws SQLException, IOException, ClassNotFoundException {
        this.nameFrame = frame;
    }
}
