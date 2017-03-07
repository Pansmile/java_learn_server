package pro.i_it.learn.server.module;

import pro.i_it.learn.server.module.chat.pansmile.ChatManager;
import pro.i_it.learn.server.module.dataManager.pansmile.DataManager;
import pro.i_it.learn.server.module.interfaces.IChatManager;
import pro.i_it.learn.server.module.interfaces.IDataManager;
import pro.i_it.learn.server.module.interfaces.IModuleManager;
import pro.i_it.learn.server.module.interfaces.ISocketIOManager;
import pro.i_it.learn.server.module.socketIOManager.pansmile.SocketIOManager;

/**
 * Created by syn on 01.03.17.
 */
public class ModuleManager implements IModuleManager {
    private static ModuleManager onlyManager;
    private SocketIOManager socketIOManager;
    private ChatManager chatManager;
    private DataManager dataManager;

    private ModuleManager() {
        chatManager = new ChatManager();
        dataManager = new DataManager();
        socketIOManager = new SocketIOManager();
    }

    public static ModuleManager getModuleManager() {
        if (onlyManager == null) {
            onlyManager = new ModuleManager();
        }
        return onlyManager;
    }

    @Override
    public ISocketIOManager getSocketIOManager() {
        return socketIOManager;
    }

    @Override
    public IChatManager getChatManager() {
        return chatManager;
    }

    @Override
    public IDataManager getDataManager() {
        return dataManager;
    }
}

