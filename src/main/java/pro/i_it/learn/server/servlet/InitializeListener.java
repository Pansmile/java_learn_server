package pro.i_it.learn.server.servlet;

import pro.i_it.learn.server.module.ModuleManager;
import pro.i_it.learn.server.module.socketIOManager.pansmile.SocketIOManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by pansmile on 07.03.17.
 */
@WebListener
public class InitializeListener implements ServletContextListener {
    private SocketIOManager socketIOManager = (SocketIOManager) ModuleManager.getModuleManager().getSocketIOManager();


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("startup");
        try {
            socketIOManager.startSocketIOServer();
            System.out.println("SERVER STARTED!");
        } catch (Exception e0) {
            e0.printStackTrace();
        }



    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            socketIOManager.stopSocketIOServer();
            System.out.println("SERVER STOPPED!");
        } catch (Exception e0) {
            e0.printStackTrace();
        }
        System.out.println("shutdown");

    }

}
