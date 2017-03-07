package pro.i_it.learn.server.module.dataManager.pansmile;

import pro.i_it.learn.server.model.MessageModel;
import pro.i_it.learn.server.model.UserModel;
import pro.i_it.learn.server.module.data.interfaces.IDao;
import pro.i_it.learn.server.module.data.pansmile.MessageDao;
import pro.i_it.learn.server.module.data.pansmile.UserDao;
import pro.i_it.learn.server.module.interfaces.IDataManager;

/**
 * Created by pansmile on 04.03.17.
 */
public class DataManager implements IDataManager {
    private UserDao userDao;
    private MessageDao messageDao;

    public DataManager() {
        userDao = new UserDao();
        messageDao = new MessageDao();
    }

    @Override
    public IDao<UserModel> getUserDao() {
        return userDao;
    }

    @Override
    public IDao<MessageModel> getMessageDao() {
        return messageDao;
    }
}
