package pro.i_it.learn.server.module;

import pro.i_it.learn.server.module.interfaces.IChatManager;
import pro.i_it.learn.server.module.interfaces.IDataManager;
import pro.i_it.learn.server.module.interfaces.IModuleManager;
import pro.i_it.learn.server.module.interfaces.ISocketIOManager;

/**
 * Created by syn on 01.03.17.
 */
public class ModuleManager implements IModuleManager {
    @Override
    public ISocketIOManager getSocketIOManager() {
        return null;
    }

    @Override
    public IChatManager getChatManager() {
        return null;
    }

    @Override
    public IDataManager getDataManager() {
        return null;
    }
}

