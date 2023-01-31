package dev.zwazel.glassfish.util;

import dev.zwazel.glassfish.classes.dao.UserDao;
import dev.zwazel.glassfish.classes.enums.UserRole;
import dev.zwazel.glassfish.classes.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to initialize the database with Data on startup.
 *
 * @author Zwazel
 * @since 0.3
 */
@Singleton
@Startup
public class InitDbOnStartup {
    /**
     * This method is used to initialize the database with Data on startup.
     *
     * @author Zwazel
     * @since 0.3
     */
    @PostConstruct
    public void init() {
        System.out.println("Initiation of DB");

        List<User> users = getUsers();
        UserDao userDao = new UserDao();
        for (User u : users) {
            User userFromDb = userDao.findByUsername(u.getUsername());
            if (userFromDb == null) {
                userDao.save(u);
                System.out.println(u.getUsername() + " added to DB");
            } else {
                System.out.println(u.getUsername() + " already exists");
            }
        }

        System.out.println("DB initiation finished");
    }

    /**
     * This method is used to get the Users for the Database.
     *
     * @return the Users for the Database
     * @author Zwazel
     * @since 0.3
     */
    private List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String verySecureUserPassword = "v3Ry$ecUre";

        User user = User.builder()
                .username("user")
                .formPassword(verySecureUserPassword)
                .userRole(UserRole.USER)
                .build();

        users.add(user);

        User admin = User.builder()
                .username("admin")
                .formPassword(verySecureUserPassword)
                .userRole(UserRole.ADMIN)
                .build();

        users.add(admin);

        return users;
    }
}
