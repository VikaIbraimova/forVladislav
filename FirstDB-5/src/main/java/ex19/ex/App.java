package ex19.ex;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Пример работы с Базой Данных H2
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.h2.Driver");
            //Установка соединения
            conn = DriverManager.getConnection("jdbc:h2:file://E:\\Java\\Java_IDEAProject\\FirstDB-5\\test","sa","");

            //создание statement
                stmt = conn.createStatement();
        //Выполнение запроса
            rs = stmt.executeQuery("select * from users");
            while (rs.next()) {
                System.out.println("login: " + rs.getString("login")
                        +",password: " + rs.getString("password")
                        +", columnaccess: " + rs.getString("columnaccess"));
            }
        } catch (ClassNotFoundException ex2) {
            //e.printStackTrace();
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex2);
        } catch (SQLException ex3) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex3);
        }
        finally {
            //e.printStackTrace();
            if (conn != null ) {
                try {
                    conn.close();
                } catch (SQLException ex4) {
                    //e.printStackTrace();
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex4);
                }
            }
        }
    }
}
