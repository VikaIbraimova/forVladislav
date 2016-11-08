package ex7;

import ex7.controller.DataExcelController3;
import ex7.view.MainFrame;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Точка входа в приложение
 *
 */
public class Main
{
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        DataExcelController3 dt3 = new DataExcelController3();
        MainFrame mainFrame = new MainFrame();

    }
}
