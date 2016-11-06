package ex5;

import ex5.view.MainFrame;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Точка входа в приложение
 *
 */
public class Main
{
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        //FrameUsersController fu = new FrameUsersController();
        MainFrame mainFrame = new MainFrame();
    }
}
