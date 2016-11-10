package ex8.controller;

import ex8.utills.FileUtills;
import org.jdom2.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataExcelController {
    //Поля
    static Map<String,String> filesPath;
    public static final String SETTINGS_XML = "settings2.xml";
    public static Map<String, String> getFilesPath() {
        return filesPath;
    }

    public DataExcelController() throws IOException, SAXException, ParserConfigurationException {
        filesPath = new HashMap<String, String>();
        //----------Чтение XML-файла с логинами и паролями пользователей
       /* try {*/
            // мы можем создать экземпляр JDOM Document из классов DOM, SAX и STAX Builder
            FileUtills.VerificationExistsPropertiesFile(SETTINGS_XML);
            org.jdom2.Document jdomDocument = FileUtills.createJdomUsingDomParser(SETTINGS_XML);
            Element root = jdomDocument.getRootElement();
            // получаем список всех элементов - тег Path
            List<Element> pathsListElements = root.getChildren("Path");
            for (Element pathEl : pathsListElements) {
                filesPath.put(pathEl.getChildText("nameFile"),pathEl.getChildText("adress"));
            }
        /*} catch (Exception e) {
            e.printStackTrace();
        }*/
        //----------Чтение XML-файла с логинами и паролями пользователей
        // перебор элементов - проверка работоспособности
        for(Map.Entry<String, String> item : filesPath.entrySet())
            System.out.println("Key: " + item.getKey()+ "-" + "Value: " + item.getValue());
    }
}
