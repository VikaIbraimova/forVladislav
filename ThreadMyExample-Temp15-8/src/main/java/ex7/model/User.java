package ex7.model;

/**
 * Created by vika on 06.11.16.
 */
public class User {
    private String login;
    private String password;
    private String tableFrame;

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", tableFrame='" + tableFrame + '\'' +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTableFrame() {
        return tableFrame;
    }

    public void setTableFrame(String tableFrame) {
        this.tableFrame = tableFrame;
    }
}
