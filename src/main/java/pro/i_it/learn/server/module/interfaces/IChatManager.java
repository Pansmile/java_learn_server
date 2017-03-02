package pro.i_it.learn.server.module.interfaces;

import pro.i_it.learn.server.model.MessageModel;

import java.util.ArrayList;

/**
 * Created by syn on 02.03.17.
 */
public interface IChatManager {
    void inputMessage(MessageModel model);

    void putSender(ISender sender);

    ArrayList<MessageModel> getHistory();
}
