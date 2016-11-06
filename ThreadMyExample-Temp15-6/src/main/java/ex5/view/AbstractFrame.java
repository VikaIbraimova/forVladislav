package ex5.view;

import ex5.model.Data;
import ex5.model.TableUtills;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFrame extends JFrame {
    public static final String excelPUTH = "C:/Temp/123.xls";
    JButton jbAdd;
    JButton jbDelete;
    JButton jbEdit;
    //from JTableExample4
    //Задаем формат вывода данных типа Дата
    //public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    //Кол-во строк в документе
    int rowCount = 0;
    //Объект таблицы
    JTable jTabPeople;
    //DataExcelController myDataExcel;
    //Старое имя
    //ArrayList humans;
    //Новое
    ArrayList excelCellText;

    public ArrayList getExcelCellText() {
        return excelCellText;
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
        //ArrayList excelCellText = new ArrayList<>();
        //excelCellText.add(new Data("John", "Smith", "1231231"));
        //excelCellText.add(new Data("George", "White", "321321312"));
        //excelCellText.add(new Data("Olga", "Bregneva", "7171711"));
        //JTable jTabPeople;
        //Object columnNames[];
        //List<String> myList1 = new ArrayList<String>();
        //List<String> myList2 = new ArrayList<String>();
        //List<String> myList3 = new ArrayList<String>();
        //List<String> myList4 = new ArrayList<String>();
        //Старое имя
        //List<String> myListResult = new ArrayList<String>();
        //Новое имя
        List<String> cellsSheetExcel = new ArrayList<String>();
        //int sizeMyList1 = 0;
        //Создали поток к файлу, передали в качестве аргумента путь к этому файлу
        FileInputStream fis = new FileInputStream(excelPUTH);
        Workbook wb = new HSSFWorkbook(fis);
        /**
         * Перебор всех ячеек листа
         */
        int k2 = 0;
        for (Row row : wb.getSheetAt(2)) {
            k2++;
            for (Cell cell : row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                cellsSheetExcel.add(TableUtills.getCellText(cell) + " ");
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
        excelCellText = new ArrayList<String>();
        //Старое имя
        //Data myData4;
        //Новое имя
        Data rowCellsSheetExcel;
        /**
         * Сделала i с трех и убрала в условии if i==0,
         * потому что не нужна из ArrayList(содержит Excel) первая строка: Фирма Доход ГодовойДоход
         */
        for (int i = 3; i < 12; i++) {
            rowCellsSheetExcel = new Data();
            if (/*i == 0 ||*/ i == 3 || i == 6 || i == 9) {
                rowCellsSheetExcel.setCol1(cellsSheetExcel.get(i));
                i++;
                rowCellsSheetExcel.setCol2(cellsSheetExcel.get(i));
                i++;
                rowCellsSheetExcel.setCol3(cellsSheetExcel.get(i));
            }
            excelCellText.add(rowCellsSheetExcel);
        }
        //Создадим модель таблицы
        ///TableModel tModel = new TableModel(excelCellText);
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

}