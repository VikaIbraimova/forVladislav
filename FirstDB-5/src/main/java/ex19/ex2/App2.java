package ex19.ex2;

/**
 * Created by vika on 30.11.16.
 */
public class App2 {
    public static void main(String[] args) {
        UserDAO ud = new UserDAO();
        ud.select();
        ud.findByLogin("Sidorov");
    }
}
