package pro.i_it.learn.server.servlet;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import pro.i_it.learn.server.model.MessageModel;
import pro.i_it.learn.server.module.ModuleManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by pansmile on 07.03.17.
 */
@WebListener
public class InitializeListener implements ServletContextListener {
    private SocketIOServer server;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("startup");
        try {
            initServer();
            server.start();
            System.out.println("SERVER STARTED!");
        } catch (Exception e0) {
            e0.fillInStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        server.stop();
        System.out.println("SERVER STOPPED!");
        System.out.println("shutdown");

    }

   private void initServer() throws Exception {
        if (server == null) {
            Configuration config = new Configuration();
            config.setPort(9090);
            config.setHostname("localhost");
            server = new SocketIOServer(config);
            System.out.println("SERVER CREATED");
            server.addEventListener("MESSAGE", String.class,
                    (client, message, ackRequest) -> {
                        System.out.println("Client said: " + message);
                        ModuleManager.getModuleManager().getChatManager().inputMessage(
                                new MessageModel(client.getNamespace().getName(), message));
                    });

        }
    }
}
