package ex8.controller;

import ex8.utills.FileUtills;
import org.jdom2.Element;

import java.io.IOException;
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
    //Map<String,String> pathFile;
    public static final String SETTINGS_XML = "settings2.xml";
    //Методы
    public Map<String, String> getTableUsers() {
        return tableUsers;
    }

    public Map<String, String> getUserLogPass() {
        return userLogPass;
    }

    public FrameUsersController() throws IOException {
        tableUsers = new HashMap<String, String>();
        userLogPass = new HashMap<String, String>();
        //pathFile = new HashMap<String, String>();
        //----------Чтение XML-файла с логинами и паролями пользователей
        try {
            // мы можем создать экземпляр JDOM Document из классов DOM, SAX и STAX Builder
            //org.jdom2.Document jdomDocument = FileUtills.createJdomUsingDomParser(SETTINGS_XML);

            org.jdom2.Document jdomDocument = FileUtills.createJdomUsingDomParser(SETTINGS_XML);
            Element root = jdomDocument.getRootElement();
            // получаем список всех элементов - тег User
            List<Element> userListElements = root.getChildren("User");
            for (Element userEl : userListElements) {
                tableUsers.put(userEl.getChildText("login"),userEl.getChildText("tableFrame"));
                userLogPass.put(userEl.getChildText("login"),userEl.getChildText("password"));
            }
            //получаем список путей к файлам - тег Path
            /*List<Element> pathListElements = root.getChildren("Path");
            for (Element pathEl:pathListElements) {
                pathFile.put(pathEl.getChildText("nameFile"),pathEl.getChildText("adress"));
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
        //----------Чтение XML-файла с логинами и паролями пользователей
        // перебор элементов
        for(Map.Entry<String, String> item : tableUsers.entrySet())
            System.out.println("Key: " + item.getKey()+ "-" + "Value: " + item.getValue());
       /* for(Map.Entry<String, String> item2 : pathFile.entrySet())
            System.out.println("Key: " + item2.getKey()+ "-" + "Value: " + item2.getValue());*/
    }

    //Вынесла в отдельный класс FileUtills
    // получаем экземпляр JDOM Document с помощью DOM Parser
    /*private static org.jdom2.Document createJdomUsingDomParser(String fileName)
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
