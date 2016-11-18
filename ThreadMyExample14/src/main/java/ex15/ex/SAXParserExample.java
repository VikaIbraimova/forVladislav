package ex15.ex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
/**
 * Изменение XML файла с помощью JDOM XML:
 * тот же пример, только уже для моего приложения-примера:Организация многопольщовательской работы с Excel-файлом
 */
public class SAXParserExample {

    private static final String FILENAME = "settings2.xml";

    public static void mainSAX (/*String[] args*/) {
        SAXBuilder saxBuilder = new SAXBuilder();
        File xmlFile = new File(System.getProperty("user.dir")
                + File.separator + FILENAME);
        try {
            Document document = saxBuilder.build(xmlFile);
            Element configuration = document.getRootElement();
            Element changes = configuration.getChild("Changes");
            // Изменим статус документа (значение элемента aboutFile)
            changes.getChild("aboutFile").setText("changed");
            // Удалим тег Changes
            //configuration.removeChild("Changes");
            // Сохраняем результат
            XMLOutputter xmlOutputter = new XMLOutputter();
            xmlOutputter.setFormat(Format.getPrettyFormat());
            xmlOutputter.output(document,
                    new FileOutputStream(xmlFile.getAbsolutePath()));
            //xmlOutputter.output(document, System.out);
        } catch (JDOMException | IOException ex) {
            Logger.getLogger(SAXParserExample.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
