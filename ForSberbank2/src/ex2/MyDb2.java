package ex2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Дана таблица; ФИО атлета,время прохождения дистанции
 * Определить время, за котрое 90% атлетов пройдет дистаницию
 */
public class MyDb2 {
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
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM athletes");
            ResultSet rs = stmt.executeQuery();

            int myTime = 0;
            double middleTime = 0;
            double numberPeople = 0;
            double peoplePercent;
            double middleTime90PersentPeople;
            while (rs.next()) {
                String time = rs.getString("time");
                numberPeople++;
                String nameAthletes = rs.getString("nameAthletes");
                try {
                    myTime = Integer.parseInt(time);
                } catch (NumberFormatException e) {
                    System.err.println("Неверный формат строки!");
                }
                middleTime += myTime;
                System.out.println("time : " + time);
                System.out.println("nameAthletes : " + nameAthletes);
            }
            middleTime = middleTime /numberPeople;
            System.out.println("Среднее время "+ numberPeople + " :  " +middleTime);
            peoplePercent = numberPeople / 100;
            System.out.println("Процент людей: " + peoplePercent);
            middleTime90PersentPeople = (((middleTime * 100) / peoplePercent)/100) * 0.9;
            System.out.println("Среднее время 90% атлетов:" + middleTime90PersentPeople);
        } catch (Exception ex) {
            Logger.getLogger(MyDb2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MyDb2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
