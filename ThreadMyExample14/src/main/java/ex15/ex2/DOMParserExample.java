package ex15.ex2;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by vika on 14.11.16.
 */
public class DOMParserExample {

    public static void mainDOM(/*String[] args*/) {
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("settings4.xml");

            // Вызываем метод для добавления нового элемента
            addNewElement(document);

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    // Функция добавления нового элемента и записи результата в файл
    private static void addNewElement(Document document) throws TransformerFactoryConfigurationError, DOMException {
        // Получаем корневой элемент
        Node root = document.getDocumentElement();

        // Создаем новый элемент Configuration/Cganges
        // Сам элемент <Changes>
        Element changes = document.createElement("Changes");
        // <nameFile2>
        Element nameFile2 = document.createElement("nameFile2");
        // Устанавливаем значение текста внутри тега
        nameFile2.setTextContent("123");
        // <aboutFile>
        Element aboutFile = document.createElement("aboutFile");
        //aboutFile.setTextContent("VIKA");
        aboutFile.setTextContent("changed");

        // Добавляем внутренние элементы в элемент <Changes>
        changes.appendChild(nameFile2);
        changes.appendChild(aboutFile);
        // Добавляем Changes в корневой элемент Configuration
        root.appendChild(changes);
        deleteFile();
        // Записываем XML в файл
        writeDocument(document);
    }

    private static void deleteFile(){
        File file = new File("settings4.xml");
        if(file.delete()){
            System.out.println("settings4.xml файл был удален с корневой папки проекта");
        }else System.out.println("Файл settings2.xml не был найден в корневой папке проекта");

    }

    // Функция для сохранения DOM в файл
    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("settings4.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}