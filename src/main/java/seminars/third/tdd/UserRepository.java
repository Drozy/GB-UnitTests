package seminars.third.tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (!user.isAuthenticate) return;
        data.add(user);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logoutUsers() {
        Iterator<User> userIterator = data.iterator();
        while (userIterator.hasNext()) {
            User nextUser = userIterator.next();
            if (!nextUser.isAdmin) {
                nextUser.isAuthenticate = false;
                userIterator.remove();
            }
        }
    }
}