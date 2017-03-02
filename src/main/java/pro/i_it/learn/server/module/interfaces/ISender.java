package pro.i_it.learn.server.module.interfaces;

import pro.i_it.learn.server.model.MessageModel;

/**
 * Created by syn on 02.03.17.
 */
public interface ISender {
    boolean sendAll(MessageModel messageModel);

    boolean sendById(MessageModel messageModel, int userId);

}
