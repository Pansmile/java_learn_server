package pro.i_it.learn.server.servlet;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
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
        System.out.println("Server startup");
        try {
            initServer();
            server.start();
            System.out.println("SERVER STARTED");

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Server shutdown");
        server.stop();
        System.out.println("SERVER STOPPED");

    }

    private void initServer() {
        if (server == null) {
            Configuration config = new Configuration();
            config.setPort(8080);
            config.setHostname("localhost");
            server = new SocketIOServer(config);
            System.out.println("SERVER CREATED");
            server.addEventListener("MESSAGE", String.class,
                    (client, message, ackRequest) -> {
                        System.out.println("Client said: " + message);
                    });

        }
    }
}
