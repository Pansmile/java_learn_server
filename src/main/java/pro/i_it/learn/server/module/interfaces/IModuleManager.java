package pro.i_it.learn.server.module.interfaces;

/**
 * Created by syn on 02.03.17.
 */
public interface IModuleManager {
    ISocketIOManager getSocketIOManager();

    IChatManager getChatManager();

    IDataManager getDataManager();
}
