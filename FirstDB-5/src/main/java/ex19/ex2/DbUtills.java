package ex19.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by vika on 30.11.16.
 */
public class DbUtills {
    static Connection dbConnection = null;
    static Exception ex;
    Exception ex2 = null;
    //Метод устанавливает соединение с БД
    public static Connection getDBConnection(){
        try {
            Class.forName("org.h2.Driver");
            //Установка соединения
            dbConnection = DriverManager.getConnection("jdbc:h2:file://E:\\Java\\Java_IDEAProject\\FirstDB-5\\test","sa","");
            //System.out.println("Установлено соединение с БД");
        } catch (ClassNotFoundException ex) {
            System.out.println("Where is your H2 JDBC Driver?");
                //e.printStackTrace();
            Logger.getLogger(App2.class.getName()).log(Level.SEVERE,null,ex);
            //return;
        } catch (SQLException ex2) {
            //ex2.printStackTrace();
            Logger.getLogger(App2.class.getName()).log(Level.SEVERE,null,ex2);
        }
        return dbConnection;
    }

    //Метод удаляет соединение с БД
    public static void deleteDBConnection(){
        ex = null;
        if (dbConnection != null ) {
            try {
                dbConnection.close();
                System.out.println("Соединение с БД закрыто");
            } catch (SQLException ex) {
                //e.printStackTrace();
                Logger.getLogger(App2.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
}
