package ex10.view;

import ex10.controller.DataExcelController3;
import ex10.model.Data;
import ex10.utills.TableUtills;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFrame extends JFrame {
    //Вынесла путь к файлу Excel с данными в файл settings2.xml
    public static final String EXCEL_PATH = DataExcelController3.getFilesPath().get("123");
    JButton jbAdd;
    JButton jbDelete;
    JButton jbEdit;
    //Кол-во строк в документе
    int rowCount = 0;
    //Объект таблицы
    JTable jTabPeople;
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
        //--------------Для формы------------------
        //----------Заполненение данных для формы--------
        List<String> cellsSheetExcel = new ArrayList<String>();
        //Создали поток к файлу, передали в качестве аргумента путь к этому файлу-сделать обработку исключения

        FileInputStream fis = new FileInputStream(EXCEL_PATH);
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
        rowCount = k2;
        excelCellText = new ArrayList<String>();
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
    }

    public abstract void clickAdd();
    public abstract void clickDelete();

    public void clickEdit() {
        System.out.println("Привет из абстрактного класса");
    }

}