package pro.i_it.learn.server.module.interfaces;

import pro.i_it.learn.server.model.MessageModel;
import pro.i_it.learn.server.model.UserModel;
import pro.i_it.learn.server.module.data.interfaces.IDao;

/**
 * Created by syn on 02.03.17.
 */
public interface IDataManager {
    IDao<UserModel> getUserDao();

    IDao<MessageModel> getMessageDao();
}
