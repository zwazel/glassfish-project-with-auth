package dev.zwazel.glassfish.util;

import dev.zwazel.glassfish.classes.dao.UserDao;
import dev.zwazel.glassfish.classes.enums.UserRole;
import dev.zwazel.glassfish.classes.model.User;

/**
 * Tester class for the database connection.
 *
 * @author Zwazel
 * @since 0.3
 */
public class TestDbConnection {
    /**
     * Main method for testing the database connection.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        User user = User.builder()
                .username("test")
                .formPassword("test")
                .userRole(UserRole.USER)
                .build();

        UserDao userDao = new UserDao();
        User alreadyExistingUser = userDao.findByUsername(user.getUsername());
        if (alreadyExistingUser == null) {
            userDao.save(user);
        } else {
            System.out.println("User already exists");
        }

        System.out.println(user.getUsername());
    }
}
