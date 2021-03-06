package ex;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vika on 25.10.16.
 */
public class FrameUsers {
    Map<String,String> tableUsers;
    Map<String,String> userLogPass;
    //Задаем формат вывода данных типа Дата
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

    public Map<String, String> getTableUsers() {
        return tableUsers;
    }

    public Map<String, String> getUserLogPass() {
        return userLogPass;
    }

    public FrameUsers() throws IOException {
        tableUsers = new HashMap<>();
        userLogPass = new HashMap<>();

        //Создали поток к файлу, передали в качестве аргумента путь к этому файлу
        FileInputStream fis = new FileInputStream("C:/Temp/1235.xls");
        Workbook wb = new HSSFWorkbook(fis);
        //int countCell = 0;
        int countRow = 0;
        for (Row row : wb.getSheetAt(2)) {
            countRow++;
            if (countRow > 1) {
                String log = null;
                String passw = null;
                String tableu = null;
                int countCell = 0;
                for (Cell cell : row) {
                    countCell++;
                    if (countCell == 1) {
                        //CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                        log = getCellText(cell);
                        //countCell++;
                    }
                    if (countCell == 2){
                        passw = getCellText(cell);
                    }
                    if (countCell == 3) {
                        tableu = getCellText(cell);
                    }
                    userLogPass.put(log,passw);
                    tableUsers.put(log,tableu);
                }
            }

        }
        fis.close();
        // перебор элементов
        //for(Map.Entry<String, String> item : userLogPass.entrySet())
        //System.out.println("Key: " + item.getKey()+ "-" + "Value: " + item.getValue());
        for(Map.Entry<String, String> item : tableUsers.entrySet())
            System.out.println("Key: " + item.getKey()+ "-" + "Value: " + item.getValue());
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
