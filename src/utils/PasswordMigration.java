package utils;

import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import it.unisa.model.*;

public class PasswordMigration {
    public static void migratePasswords() {

        UserDao userDao = new UserDao();

        try {
            // Recupera tutti gli utenti dal database
            List<UserBean> users = userDao.doRetrieveAll("");

            for (UserBean user : users) {
                // Hash della password dell'utente
                String hashedPassword = PasswordUtils.hashPassword(user.getPassword());
                user.setPassword(hashedPassword);

                // Aggiorna la password crittografata nel database
                userDao.updateUserPassword(user);
            }

            System.out.println("Password migration completed successfully.");

        } catch (SQLException e) {
            System.out.println("An error occurred during password migration: " + e.getMessage());
        }
    }
}