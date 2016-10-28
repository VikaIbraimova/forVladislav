package ex;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vika on 25.10.16.
 */
public class FrameUsers {
    //Поля
    Map<String,String> tableUsers;
    Map<String,String> userLogPass;
    List<User> users;
    //Задаем формат вывода данных типа Дата
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    String fileName = "settings.xml";

    //Методы
    public Map<String, String> getTableUsers() {
        return tableUsers;
    }

    public Map<String, String> getUserLogPass() {
        return userLogPass;
    }

    public List<User> getUsers() {
        return users;
    }

    public FrameUsers() throws IOException {
        tableUsers = new HashMap<String, String>();
        userLogPass = new HashMap<String, String>();
        //----------Чтение XML-файла с логинами и паролями пользователей
        try {
            // мы можем создать экземпляр JDOM Document из классов DOM, SAX и STAX Builder
            org.jdom2.Document jdomDocument = createJDOMusingDOMParser(fileName);
            Element root = jdomDocument.getRootElement();
            // получаем список всех элементов User
            List<Element> userListElements = root.getChildren("User");
            /**
             * Список объектов класса User.Каждый элемент списка - это новый объект
             * класса User с заполненными полями
             */
            users = new ArrayList<User>();
            for (Element userEl : userListElements) {
                //User user = new User();
                //user.setLogin(userEl.getChildText("login"));
                //user.setPassword(userEl.getChildText("password"));
                //user.setTableFrame(userEl.getChildText("tableFrame"));
                //users.add(user);

                tableUsers.put(userEl.getChildText("login"),userEl.getChildText("tableFrame"));
                userLogPass.put(userEl.getChildText("login"),userEl.getChildText("password"));
            }
            //Печататем полученный список объектов класса User
            /*for (User user : users) {
                System.out.println(user.toString());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        //----------Чтение XML-файла с логинами и паролями пользователей

        // перебор элементов
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

    // получаем экземпляр JDOM Document с помощью DOM Parser
    private static org.jdom2.Document createJDOMusingDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        //создаем DOM Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        documentBuilder = dbFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();

        return domBuilder.build(doc);

    }
}
