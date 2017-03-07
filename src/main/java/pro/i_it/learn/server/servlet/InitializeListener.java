package pro.i_it.learn.server.servlet;

import pro.i_it.learn.server.module.ModuleManager;
import pro.i_it.learn.server.module.interfaces.ISocketIOManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by pansmile on 07.03.17.
 */
@WebListener
public class InitializeListener implements ServletContextListener {
    private ISocketIOManager manager;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Server startup");
        try {
            ModuleManager.getModuleManager().getSocketIOManager().getServer().start();
            System.out.println("SERVER STARTED");

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Server shutdown");
        ModuleManager.getModuleManager().getSocketIOManager().getServer().stop();
        System.out.println("SERVER STOPPED");

    }
}
