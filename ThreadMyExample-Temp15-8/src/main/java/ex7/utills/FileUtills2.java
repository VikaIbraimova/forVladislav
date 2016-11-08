package ex7.utills;

import org.jdom2.input.DOMBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by vika on 09.11.16.
 */
public class FileUtills2 {
    public static org.jdom2.Document createJDOMusingDOMParser(String fileName) throws ParserConfigurationException, SAXException, IOException {
        Path path = Paths.get(fileName);

        try {
            if (!Files.isReadable(path)){
                System.out.println("Файл защищен от чтения");
            }
            if (!Files.isWritable(path)){
                System.out.println("Файл защищен от записи");
            }
            if (!Files.isExecutable(path)){
                System.out.println("Файл защищен от выполнения");
            }
            //создаем DOM Document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder;
            documentBuilder = dbFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(new File(fileName));
            DOMBuilder domBuilder = new DOMBuilder();
            return domBuilder.build(doc);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.Обратитесь к разработчику");
            //Thread.sleep(3000);
            System.exit(0);

        } catch (IOException e2) {
            System.out.println("IOException");
        }
        return null;
    }
}
