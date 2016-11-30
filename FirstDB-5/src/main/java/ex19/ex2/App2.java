package ex19.ex2;

/**
 * Created by vika on 30.11.16.
 */
public class App2 {
    public static void main(String[] args) {
        UserDAO ud = new UserDAO();
        //Смотрим кто есть в таблице
        ud.select();
        //Находим конкретного пользователя
        ud.findByLogin("Sidorov");
        //Удаляем конкретного пользователя
        ud.delete("Petrov");
        //Проверяем удалился ли из БД
        ud.select();
        //Снова его добавляем
        ud.addUser("Petrov","P","1,2");
        ud.select();
    }
}
