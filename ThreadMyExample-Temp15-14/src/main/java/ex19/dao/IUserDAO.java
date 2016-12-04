package ex19.dao;

/**
 * Created by vika on 03.12.16.
 */
public interface IUserDAO {
    public void select();
    public void update(String columnAccess,String login);
    public void findByLogin(String login);
    public void delete(String login);
    public void addUser(String login,String password,String columnAccess);
}