package ex1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Дата таблица: дата,наименование,цена
 * Вывести актуальную цену каждого товара
 */
public class MyDb {
    public static void main(String[] args) throws Exception {

        double a = 0, b = 0, c = 0,k = 0;
        double D;
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres2";
            String login = "postgres";
            String password = "postgres";
            conn = DriverManager.getConnection(url,login,password);
            PreparedStatement stmt2 = conn.prepareStatement("select * from products p where myDate = (select max(myDate) from products p2 where p.nameProduct = p2.nameProduct)\n");
            System.out.println("Актуальная цена на каждый товар на сегодняшний день");
            ResultSet rs2 = stmt2.executeQuery();
            while (rs2.next()) {
                String myDate = (rs2.getString("myDate")).trim();
                String nameProduct = (rs2.getString("nameProduct")).trim();
                String priceProduct = (rs2.getString("priceProduct")).trim();
                System.err.println("Дата: "+ myDate +" НаименованиеТовара: " + nameProduct+" ЦенаТовара:" + priceProduct);
            }
        } catch (Exception ex) {
            Logger.getLogger(MyDb.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MyDb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
