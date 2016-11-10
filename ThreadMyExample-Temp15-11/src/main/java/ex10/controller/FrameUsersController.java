package ex10.controller;

import ex10.model.User;
import ex10.utills.FileUtills3;
import org.jdom2.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Данный класс используется для извлечения информации логинов и паролей пользователей(хранятся в коллекции userLogPass)
 * - потом эти данные сверяются с данными, которые ввел пользователь.Вторая коллекция - tableUsers - нужна для определения,
 * того какие ячейки доступны для реадктирования пользователем.
 */
public class FrameUsersController {

    //Поля
    //Для контроля - тоесть какие ячейки доступны для редактирования
    Map<String,String> tableUsers;
    //Для проверки введных пользователем логина ипарол с правильными данными
    Map<String,String> userLogPass;
    List<User> users;
    public static final String SETTINGS_XML = "settings2.xml";
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
            FileUtills3.verificationExistsPropertiesFile(SETTINGS_XML);
            org.jdom2.Document jdomDocument2 = FileUtills3.createJdomUsingDomParser(SETTINGS_XML);
            Element root = jdomDocument2.getRootElement();
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
}