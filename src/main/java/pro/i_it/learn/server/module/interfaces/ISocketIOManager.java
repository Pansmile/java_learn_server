package pro.i_it.learn.server.module.interfaces;

import com.corundumstudio.socketio.SocketIOServer;

/**
 * Created by syn on 02.03.17.
 */
public interface ISocketIOManager {
    ISender getSocketIOSender();
    SocketIOServer getServer();
}
