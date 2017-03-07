package pro.i_it.learn.server.module.chat.pansmile;

import pro.i_it.learn.server.model.MessageModel;
import pro.i_it.learn.server.module.interfaces.ISender;

/**
 * Created by pansmile on 04.03.17.
 */
public class SocketIOSender implements ISender {
    @Override
    public boolean sendAll(MessageModel messageModel) {
        return false;
    }

    @Override
    public boolean sendById(MessageModel messageModel, int userId) {
        return false;
    }
}
