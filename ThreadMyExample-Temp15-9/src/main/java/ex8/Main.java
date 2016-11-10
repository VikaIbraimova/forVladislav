package ex8;

import ex8.controller.DataExcelController;
import ex8.view.MainFrame;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Точка входа в приложение
 *
 */
public class Main
{
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, ParserConfigurationException, SAXException {
        //DataExcelController dt = new DataExcelController();
        MainFrame mainFrame = new MainFrame();

    }
}
