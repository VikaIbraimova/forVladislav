package ex4.model;

import ex4.controller.FrameUsersController;
import ex4.view.Frame;
import ex4.view.MainFrame;

import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class TableModel extends AbstractTableModel {
    //ArrayList<Human> humans;
    ArrayList<Data> myDatas;

    FrameUsersController frameUsersController;
    Frame frame;
    MainFrame mainFrame;
    String nameFrame;

   /* TableModel(ArrayList<Human> humans) {
        super();
        this.humans = humans;
    }*/

    public TableModel(ArrayList<Data> myDatas) throws IOException {
        super();
        this.myDatas = myDatas;
        //frameUsersController = new FrameUsersController();
        //frame = new Frame();
    }

    @Override
    public int getRowCount() {
        //return humans.size();
        return myDatas.size();
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
                    //return humans.get(r).getName();
                    return myDatas.get(r).getCol1();
                case 1:
                    //return humans.get(r).getSurname();
                    return myDatas.get(r).getCol2();
                default:
                    return "";
            }
        }
        if (frame.equals("Frame2")) {
            switch (c) {
                case 0:
                    //return humans.get(r).getName();
                    return myDatas.get(r).getCol1();
                case 1:
                    //return humans.get(r).getTelephone();
                    return myDatas.get(r).getCol3();
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
                    //result = "Name";
                    result = "Фирма";
                    break;
                case 1:
                    //result = "Surname";
                    result = "Доход";
                    break;
            }
            return result;
        }
        if (frame.equals("Frame2")) {
            switch (c) {
                case 0:
                    //result = "Name";
                    result = "Фирма";
                    break;
                case 1:
                    //result = "Telephone";
                    result = "ГодовойДоход";
                    break;
            }
            return result;
        }
        return null;
    }

    public void getFrameUsers(String frame) throws SQLException, IOException, ClassNotFoundException {
        //frameUsersController.getTableUsers();
        //for(Map.Entry<String, String> item : frameUsersController.getTableUsers().entrySet())
         //   System.out.println("Key: " + item.getKey()+ "-" + "Value: " + item.getValue());

        //frame.getNumberCol();
        //for (int i = 0; i < frame.getNumberCol().length; i++) {
        //    System.out.println(frame.getNumberCol()[i]);
       // }
        //mainFrame.getNameUser();
        //mainFrame = new MainFrame();
        //System.out.println(mainFrame.getNameUser());

        //System.out.println(frame);
        //return frame;
        this.nameFrame = frame;
    }
}
