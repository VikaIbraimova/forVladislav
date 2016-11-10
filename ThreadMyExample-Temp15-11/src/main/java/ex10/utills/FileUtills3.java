package ex10.utills;

import org.jdom2.input.DOMBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by vika on 06.11.16.
 */
public class FileUtills3 {

    //public static org.jdom2.Document createJdomUsingDomParser(String fileName)
    public static org.jdom2.Document createJdomUsingDomParser(String fileName) throws ParserConfigurationException, SAXException, IOException {
        //создаем DOM Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        documentBuilder = dbFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();
        return domBuilder.build(doc);
    }

    public static void verificationExistsPropertiesFile(String fileName){
        File file = new File(fileName);
        if (file.exists()) {
            Path path = Paths.get(fileName);
            if (!Files.isReadable(path)) {
                System.out.println("Файл защищен от чтения");
            }
            if (!Files.isWritable(path)) {
                System.out.println("Файл защищен от записи");
            }
            if (!Files.isExecutable(path)) {
                System.out.println("Файл защищен от выполнения");
            }
        } else {
            System.out.println("Файл c настройками для приложения не найден.Обратитесь к разработчику.");
            //new Frame("Error");
            //JLabel jl = new JLabel("Файл c настройками для приложения не найден.Обратитесь к разработчику.");
            //add(jl);
            System.exit(1);
        }
        //return null;
    }
}