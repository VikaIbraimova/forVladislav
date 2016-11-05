package ex4.view;

import ex4.controller.DataExcelController;
import ex4.model.Data;
import ex4.model.TableModel;
import ex4.controller.DataExcelController;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFrame extends JFrame {
    JButton jbAdd;
    JButton jbDelete;
    JButton jbEdit;
    //from JTableExample4
    //Задаем формат вывода данных типа Дата
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    //Кол-во строк в документе
    int rowCount = 0;
    //Объект таблицы
    JTable jTabPeople;
    DataExcelController myDataExcel;

    ArrayList humans;

    public ArrayList getHumans() {
        return humans;
    }

    public AbstractFrame() throws HeadlessException, IOException, SQLException, ClassNotFoundException {
        setTitle("Working with Excel");
        getContentPane().setLayout(new FlowLayout());
        this.jbAdd = new JButton("Add");
        add(jbAdd);
        this.jbDelete = new JButton("Delete");
        add(jbDelete);
        this.jbEdit = new JButton("Edit");
        add(jbEdit);
        setBounds(100, 100, 300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //this.frame = frame;
        //from JTableExample4
        //-----------Для формы-------------------
        //Создаем новый контейнер JFrame
        //JFrame jfrm = new JFrame("JTableExample5");
        //Устанавливаем диспетчер компоновки
        //jfrm.getContentPane().setLayout(new FlowLayout());
        //Устанавливаем размер окна
        //jfrm.setSize(400, 200);
        //jfrm.setSize(1000, 170);
        //Устанавливаем завершение программы при закрытии окна
        //jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //--------------Для формы------------------
        //----------Заполненение данных для формы--------
        //Создадим список из сущностей класса Human
        //ArrayList humans = new ArrayList<>();
        //humans.add(new Data("John", "Smith", "1231231"));
        //humans.add(new Data("George", "White", "321321312"));
        //humans.add(new Data("Olga", "Bregneva", "7171711"));
        JTable jTabPeople;
        Object columnNames[];
        List<String> myList1 = new ArrayList<String>();
        List<String> myList2 = new ArrayList<String>();
        List<String> myList3 = new ArrayList<String>();
        List<String> myList4 = new ArrayList<String>();
        List<String> myListResult = new ArrayList<String>();
        int sizeMyList1 = 0;
        //Создали поток к файлу, передали в качестве аргумента путь к этому файлу
        FileInputStream fis = new FileInputStream("C:/Temp/123.xls");
        Workbook wb = new HSSFWorkbook(fis);
        /**
         * Перебор всех ячеек листа
         */
        int k2 = 0;
        for (Row row : wb.getSheetAt(2)) {
            k2++;
            for (Cell cell : row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                myListResult.add(getCellText(cell) + " ");
                //k2++;
                //Шапка
                /*if (k2 >= 1 && k2 <= 3) {
                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    myList1.add(getCellText(cell) + " ");
                    //Apple Samsung LG
                }*/ /*else if (k2 == 4 || k2 == 7 || k2 == 10) {
                    myList2.add(getCellText(cell) + " ");
                    //четыре пять шесть
                }*/ /*else if (k2 == 5 || k2 == 8 || k2 == 11) {
                    myList3.add(getCellText(cell) + " ");
                    //4 5 6
                }*//* else if (k2 == 6 || k2 == 9 || k2 == 12) {
                    myList4.add(getCellText(cell) + " ");

                }*/
            }
            fis.close();
        }
        //System.out.println(k2);
        rowCount = k2;
/*        System.out.println(myListResult.size());
        int k =0;
        Iterator iter = myListResult.iterator();
        for (int i = 0; iter.hasNext(); i++) {
            k++;
            System.out.println(iter.next().toString() + "k = " + k);
        }*/
        humans = new ArrayList<String>();
        Data myData4;
        /**
         * Сделала i с трех и убрала в условии if i==0,
         * потому что не нужна из ArrayList(содержит Excel) первая строка: Фирма Доход ГодовойДоход
         */
        for (int i = 3; i < 12; i++) {
            myData4 = new Data();
            if (/*i == 0 ||*/ i == 3 || i == 6 || i == 9) {
                myData4.setCol1(myListResult.get(i));
                i++;
                myData4.setCol2(myListResult.get(i));
                i++;
                myData4.setCol3(myListResult.get(i));
            }
            humans.add(myData4);
        }
        //Создадим модель таблицы
        ///TableModel tModel = new TableModel(humans);
        ///tModel.getFrameUsers();
        //-----------Добавление сформированной модели на форму, окончательное отображение формы-------
        //На основе модели, создадим новую JTable
        ///jTabPeople = new JTable(tModel);
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        ///JScrollPane jscrlp = new JScrollPane(jTabPeople);
        //Устаналиваем размеры прокручиваемой области
        ///jTabPeople.setPreferredScrollableViewportSize(new Dimension(200, 100));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        //jfrm.getContentPane().add(jscrlp);
        //jfrm.setVisible(true);
        ///add(jscrlp);
        //-----------Добавление сформированной модели на форму-------
    }

    public abstract void clickAdd();
    public abstract void clickDelete();

    public void clickEdit() {
        System.out.println("Привет из абстрактного класса");
    }

    public static String getCellText(Cell cell) {
        String result = "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                //System.out.println(cell.getRichStringCellValue().getString());
                result = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                /**
                 * Явялется ли ячейка с числами датой
                 */
                if (DateUtil.isCellDateFormatted(cell)) {
                    //Строка с числами является датой
                    //System.out.println(cell.getDateCellValue());
                    //result = cell.getDateCellValue().toString();
                    //Mon Sep 05 00:00:00 GMT+03:00 2016
                    result = sdf.format(cell.getDateCellValue());
                } else {
                    //Строка с числами
                    //System.out.println(cell.getNumericCellValue());
                    result = Double.toString(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                //System.out.println(cell.getBooleanCellValue());
                result = Boolean.toString(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                //System.out.println(cell.getCellFormula());
                result = cell.getCellFormula().toString();
                break;
            default:
                break;
        }
        return result;
    }
}
