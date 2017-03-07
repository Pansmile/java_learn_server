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


    @Override
    public ISender getSocketIOSender() {

        return null;
    }

}
