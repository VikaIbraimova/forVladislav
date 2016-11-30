package ex19.ex2;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by vika on 30.11.16.
 */
public class UserDAO {

    Statement stmt = null;
    ResultSet rs = null;

    //Показ всех записей из таблицы users
    public void select(){
        try {
            //Class.forName("org.h2.Driver");
            stmt = DbUtills.getDBConnection().createStatement();
            //Выполнение запроса
            rs = stmt.executeQuery("select * from users");
            //Результат на консоль
            while (rs.next()) {
                System.out.println("login: " + rs.getString("login")
                        +",password: " + rs.getString("password")
                        +", columnaccess: " + rs.getString("columnaccess"));
            }
       // } catch (ClassNotFoundException ex2) {
            //e.printStackTrace();
       //     Logger.getLogger(App2.class.getName()).log(Level.SEVERE,null,ex2);
        } catch (SQLException ex3) {
            Logger.getLogger(App2.class.getName()).log(Level.SEVERE,null,ex3);
        }
    }

    /**
     * Редактирование колонки, в которой указано какие столбцы для редактирования, в Excel-документе,
     * доступны пользователю с данным логином
     * @param columnAccess
     * @param login
     */
    public void update(String columnAccess,String login){
        try {
            //dbConnection = getDBConnection();
            stmt = DbUtills.getDBConnection().createStatement();

            // выполняем запрос update SQL
            String updateTableSQL = "UPDATE USERS SET columnaccess = '"+columnAccess+"' WHERE login = '"+login+"'";
            stmt.execute(updateTableSQL);

            System.out.println("Record is updated to USERS table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Находим по логину информацию о пользователе
    public void findByLogin(String login){
        try {
            stmt = DbUtills.getDBConnection().createStatement();
            //Выполнение запроса
            rs = stmt.executeQuery("select * from users where login = '"+login+"'");
            //Результат на консоль
            while (rs.next()) {
                System.out.println("login: " + rs.getString("login")
                        +",password: " + rs.getString("password")
                        +", columnaccess: " + rs.getString("columnaccess"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
