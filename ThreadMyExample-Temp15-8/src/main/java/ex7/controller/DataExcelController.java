package ex7.controller;

import ex7.utills.TableUtills;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by vika on 19.10.16.
 */
public class DataExcelController {
    public static final String  EXCEL_PUTH = "C:/Temp/123.xls";

    public List<String> loadData() throws IOException {
        List<String> cellsSheetExcel = new ArrayList<String>();
        //Создали поток к файлу, передали в качестве аргумента путь к этому файлу
        FileInputStream fis = new FileInputStream(EXCEL_PUTH);
        Workbook wb = new HSSFWorkbook(fis);
        /**
         * Перебор всех ячеек листа
         */
        int k2 = 0;
        for (Row row : wb.getSheetAt(2)) {
            for (Cell cell : row) {
                k2++;
                //Шапка
                if (k2 >= 1 && k2 <= 3) {
                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    cellsSheetExcel.add(TableUtills.getCellText(cell) + " ");
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
        return cellsSheetExcel;
    }
}
