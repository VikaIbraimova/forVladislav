package ex19.utills;

import ex19.controller.DataExcelController3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by vika on 30.11.16.
 */
public class DbUtills {
    //Вынесла путь к БД с логинами и паролями пользователей в файл settings2.xml
    public static final String DB_PATH = DataExcelController3.getFilesPath().get("test");
    public static final String LOGIN = "sa";
    public static final String PASSWORD = "";
    //public static final String URL = "jdbc:h2:file://E:\\Java\\Java_IDEAProject\\ThreadMyExample-Temp15-13\\test";
    static Connection dbConnection = null;
    //Метод устанавливает соединение с БД
    public static Connection getDBConnection(){
        try {
            Class.forName("org.h2.Driver");
            if (dbConnection == null) {
                //dbConnection = DriverManager.getConnection("jdbc:h2:file://E:\\Java\\Java_IDEAProject\\ThreadMyExample-Temp15-13\\test","sa","");
                dbConnection = DriverManager.getConnection(DB_PATH,LOGIN,PASSWORD);
                //Не получилось
                //dbConnection = DriverManager.getConnection("jdbc:h2:file://" + DB_PATH);
            } else return dbConnection;
            System.out.println("Установлено соединение с БД");
        } catch (ClassNotFoundException ex) {
            System.out.println("Where is your H2 JDBC Driver?");
            //e.printStackTrace();
            Logger.getLogger(DbUtills.class.getName()).log(Level.SEVERE,null,ex);
            //return;
        } catch (SQLException ex) {
            //ex2.printStackTrace();
            Logger.getLogger(DbUtills.class.getName()).log(Level.SEVERE,null,ex);
        }
        return dbConnection;
    }

    //Метод удаляет соединение с БД
    public static void deleteDBConnection(){
        if (dbConnection != null ) {
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                    System.out.println("Соединение с БД закрыто");
                }
            } catch (SQLException ex) {
                //e.printStackTrace();
                Logger.getLogger(DbUtills.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
}