package pro.i_it.learn.server.module.socketIOManager.pansmile;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import pro.i_it.learn.server.model.MessageModel;
import pro.i_it.learn.server.module.ModuleManager;
import pro.i_it.learn.server.module.interfaces.ISender;
import pro.i_it.learn.server.module.interfaces.ISocketIOManager;


/**
 * Created by studio on 04.03.17.
 */
public class SocketIOManager implements ISocketIOManager, ISender {
    private SocketIOServer server;

    public SocketIOManager() {
        try {
            initServer();
        } catch (Exception e0) {
            e0.fillInStackTrace();
        }
    }

    private void initServer() throws Exception {
        if (server == null) {
            Configuration config = new Configuration();
            config.setPort(8080);
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

    public void startSocketIOServer() throws Exception {
        server.start();
    }

    public void stopSocketIOServer() throws Exception {
        server.stop();
    }


    @Override
    public ISender getSocketIOSender() {
        return this;
    }

    @Override
    public boolean sendAll(MessageModel messageModel) {
        server.getAllClients().forEach(client -> client.sendEvent(messageModel.getMessage()));

        return false;
    }

    @Override
    public boolean sendById(MessageModel messageModel, int userId) {
        return false;
    }
}
