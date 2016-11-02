package ex.model;

import java.util.ArrayList;

/**
 * Created by vika on 03.11.16.
 */
public class TableFrameModel extends TableModel {
    public TableFrameModel(ArrayList<Data> myDatas) {
        super(myDatas);
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                //return humans.get(r).getSurname();
                return myDatas.get(r).getCol1();
            case 1:
                //return humans.get(r).getTelephone();
                return myDatas.get(r).getCol2();
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
            //case 2:
                //result = "Telephone";
                //result = "ГодовойДоход";
                //break;
        }
        return result;
    }
}
