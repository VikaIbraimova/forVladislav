package ex7.controller;


import ex7.utills.FileUtills;
import ex7.utills.FileUtills2;
import org.jdom2.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vika on 07.11.16.
 */
public class DataExcelController3 {
    //Поля
    //Map<String,String> tableUsers;
    //Map<String,String> userLogPass;
    static Map<String,String> filesPuth;
    //List<User> users;
    //public static final String SETTINGS_XML = "settings.xml";
    public static final String SETTINGS_PUTH_XML = "settingsPuth.xml";
    //Методы

    public static Map<String, String> getFilesPuth() {
        return filesPuth;
    }

    public DataExcelController3() throws IOException {
        filesPuth = new HashMap<String, String>();
        //----------Чтение XML-файла с логинами и паролями пользователей
        try {
            // мы можем создать экземпляр JDOM Document из классов DOM, SAX и STAX Builder
            //org.jdom2.Document jdomDocument = FileUtills.createJDOMusingDOMParser(SETTINGS_PUTH_XML);
            org.jdom2.Document jdomDocument = FileUtills2.createJDOMusingDOMParser(SETTINGS_PUTH_XML);
            Element root = jdomDocument.getRootElement();
            // получаем список всех элементов User
            List<Element> puthsListElements = root.getChildren("Puth");
            /**
             * Список объектов класса User.Каждый элемент списка - это новый объект
             * класса User с заполненными полями
             */
            for (Element userEl : puthsListElements) {
                filesPuth.put(userEl.getChildText("nameFile"),userEl.getChildText("adress"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //----------Чтение XML-файла с логинами и паролями пользователей
        // перебор элементов - проверка работоспособности
        for(Map.Entry<String, String> item : filesPuth.entrySet())
            System.out.println("Key: " + item.getKey()+ "-" + "Value: " + item.getValue());
    }
}

