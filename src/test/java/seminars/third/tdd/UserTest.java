package seminars.third.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    static UserRepository repository;

    @BeforeAll
    static void setUp() {
        repository = new UserRepository();
    }

    @Test
    void checkAuthenticateUserPositive() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, password);
        assertTrue(accept);
    }

    @Test
    void checkAuthenticateUserNegative() {
        String name = "name";
        String password = "password";
        String wrongPassword = "wrongPassword";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, wrongPassword);
        assertFalse(accept);
    }

    @Test
    void checkRepositoryAddAuthenticatedUserPositive() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        user.authenticate(name, password);

        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size()).isEqualTo(currentCount + 1);

        User userInRepository = repository.data.get(repository.data.size() - 1);

        assertEquals(user, userInRepository);
    }

    @Test
    void checkRepositoryAddNotAuthenticatedUserNegative() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);

        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size()).isEqualTo(currentCount);
    }

    @Test
    void checkLogout() {
        String[] names = {"user1", "user2", "admin"};
        String[] passwords = {"password1", "password2", "adm1nP@$$W0rd"};
        boolean[] adminFlags = {false, false, true};

        for (int i = 0; i < names.length; i++) {
            User user = new User(names[i], passwords[i], adminFlags[i]);
            user.authenticate(names[i], passwords[i]);
            repository.addUser(user);
        }

        repository.logoutUsers();

        for (int i = 0; i < names.length; i++) {
            assertThat(repository.findByName(names[i])).isEqualTo(adminFlags[i]);
        }
    }

}