package ex;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vika on 19.10.16.
 */
public class MyDataExcel {
    //Задаем формат вывода данных типа Дата
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");


    public List<String> loadData() throws IOException {
        //String[] headers = {"Фирма","Доход","ГодовойДоход"};
        JTable jTabPeople;
        Object columnNames[];
        List<String> myList1 = new ArrayList<>();
        List<String> myList2 = new ArrayList<>();
        List<String> myList3 = new ArrayList<>();
        List<String> myList4 = new ArrayList<>();
        List<String> myListResult = new ArrayList<>();
        int sizeMyList1 = 0;
        //Создали поток к файлу, передали в качестве аргумента путь к этому файлу
        FileInputStream fis = new FileInputStream("C:/Temp/123.xls");
        Workbook wb = new HSSFWorkbook(fis);
        /**
         * Перебор всех ячеек листа
         */
        int k2 = 0;
        for (Row row : wb.getSheetAt(2)) {
            for (Cell cell : row) {
                //CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                //myListResult.add(getCellText(cell) + " ");
                k2++;
                //Шапка
                if (k2 >= 1 && k2 <= 3) {
                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    myList1.add(getCellText(cell) + " ");
                    //Apple Samsung LG
                } /*else if (k2 == 4 || k2 == 7 || k2 == 10) {
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
       /* Iterator iter = myList1.iterator();
        for (int i = 0; iter.hasNext(); i++) {
            System.out.println(iter.next().toString());
        }
        Iterator iter2 = myList2.iterator();
        for (int i = 0; iter2.hasNext(); i++) {
            System.out.println(iter2.next().toString());
        }
        Iterator iter3 = myList3.iterator();
        for (int i = 0; iter3.hasNext(); i++) {
            System.out.println(iter3.next().toString());
        }
        Iterator iter4 = myList4.iterator();
        for (int i = 0; iter4.hasNext(); i++) {
            System.out.println(iter4.next().toString());
        }*/
        return myList1;
        //return myListResult;
    }

    /**
     * Универсальная функция для получения строки из ячейки,
     * в которой может быть
     * текст(String)
     * число
     * булево значение
     * На вход подается ячейка из Excel-документа
     * @param cell
     * @return
     */
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
