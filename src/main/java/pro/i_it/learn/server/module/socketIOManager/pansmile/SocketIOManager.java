package pro.i_it.learn.server.module.socketIOManager.pansmile;

import pro.i_it.learn.server.module.interfaces.ISender;
import pro.i_it.learn.server.module.interfaces.ISocketIOManager;
import com.corundumstudio.socketio.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by studio on 04.03.17.
 */
public class SocketIOManager implements ISocketIOManager {
    private Configuration config;
    private SocketIOServer server;

    public SocketIOManager() {

    }


    private void initServer() {
        if (server == null) {
            config = new Configuration();
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
    public SocketIOServer getServer() {
        if (server == null) {
            initServer();
        }
        return server;
    }

    @Override
    public ISender getSocketIOSender() {

        return null;
    }

}
