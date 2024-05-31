package utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class PasswordMigrationContextListener
 *
 */
@WebListener
public class PasswordMigrationContextListener implements ServletContextListener {

	@Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // Quando il contesto dell'applicazione viene inizializzato,
        // avvia la migrazione delle password
        PasswordMigration.migratePasswords();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // Non è necessario fare nulla quando il contesto dell'applicazione viene distrutto
    }
	
}
