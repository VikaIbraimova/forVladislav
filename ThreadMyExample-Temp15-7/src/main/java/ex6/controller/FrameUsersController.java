package ex6.controller;

import ex6.model.User;
import ex6.utils.FileUtills;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vika on 25.10.16.
 */
public class FrameUsersController {

    //Поля
    Map<String,String> tableUsers;
    Map<String,String> userLogPass;
    List<User> users;
    public static final String SETTINGS_XML = "settings.xml";
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

    public FrameUsersController() throws IOException {
        tableUsers = new HashMap<String, String>();
        userLogPass = new HashMap<String, String>();
        //----------Чтение XML-файла с логинами и паролями пользователей
        try {
            // мы можем создать экземпляр JDOM Document из классов DOM, SAX и STAX Builder
            org.jdom2.Document jdomDocument = FileUtills.createJDOMusingDOMParser(SETTINGS_XML);
            Element root = jdomDocument.getRootElement();
            // получаем список всех элементов User
            List<Element> userListElements = root.getChildren("User");
            /**
             * Список объектов класса User.Каждый элемент списка - это новый объект
             * класса User с заполненными полями
             */
            users = new ArrayList<User>();
            for (Element userEl : userListElements) {
                tableUsers.put(userEl.getChildText("login"),userEl.getChildText("tableFrame"));
                userLogPass.put(userEl.getChildText("login"),userEl.getChildText("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //----------Чтение XML-файла с логинами и паролями пользователей
        // перебор элементов
        for(Map.Entry<String, String> item : tableUsers.entrySet())
            System.out.println("Key: " + item.getKey()+ "-" + "Value: " + item.getValue());
    }

    //Вынесла в отдельный класс FileUtills
    // получаем экземпляр JDOM Document с помощью DOM Parser
    /*private static org.jdom2.Document createJDOMusingDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        //создаем DOM Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        documentBuilder = dbFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();

        return domBuilder.build(doc);

    }*/
}
