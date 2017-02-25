
package pl.goralczyk.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import pl.goralczyk.config.DBManager;


public class PrzychodnieContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        DBManager.getManager().createEntityManagerFactory();
    }

    public void contextDestroyed(ServletContextEvent sce) {
         DBManager.getManager().closeEntityManagerFactory();
    }
    
}
