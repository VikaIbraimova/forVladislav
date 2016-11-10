package ex10.controller;

import ex10.utills.FileUtills3;
import org.jdom2.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Данный класс извлекает из файла settings2.xml пути к файлам в коллекцию filesPath.В данный момент излекается путь к файлу Excel,где
 * находятся основные данные для пользователей.Затем данные коллекции filesPath используется в AbstractFrame для
 * загрузки данных из Excel-документа
 */
public class DataExcelController3 {
    //Поля
    static Map<String,String> filesPath;
    public static final String SETTINGS_PATH_XML = "settings2.xml";
    //Методы
    public static Map<String, String> getFilesPath() {
        return filesPath;
    }

    public DataExcelController3() throws IOException {
        filesPath = new HashMap<String, String>();
        //----------Чтение XML-файла с логинами и паролями пользователей
        try {
            // мы можем создать экземпляр JDOM Document из классов DOM, SAX и STAX Builder
            //org.jdom2.Document jdomDocument1 = FileUtills3.verificationExistsPropertiesFile(SETTINGS_PATH_XML);
            FileUtills3.verificationExistsPropertiesFile(SETTINGS_PATH_XML);
            org.jdom2.Document jdomDocument2 = FileUtills3.createJdomUsingDomParser(SETTINGS_PATH_XML);
            Element root = jdomDocument2.getRootElement();
            // получаем список всех элементов Path
            List<Element> puthsListElements = root.getChildren("Path");
            /**
             * Список объектов класса User.Каждый элемент списка - это новый объект
             * класса User с заполненными полями
             */
            for (Element userEl : puthsListElements) {
                filesPath.put(userEl.getChildText("nameFile"),userEl.getChildText("adress"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //----------Чтение XML-файла с логинами и паролями пользователей
        // перебор элементов - проверка работоспособности
        for(Map.Entry<String, String> item : filesPath.entrySet())
            System.out.println("Key: " + item.getKey()+ "-" + "Value: " + item.getValue());
    }
}