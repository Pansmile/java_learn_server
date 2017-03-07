package pro.i_it.learn.server.module.chat.pansmile;

import pro.i_it.learn.server.model.MessageModel;
import pro.i_it.learn.server.module.ModuleManager;
import pro.i_it.learn.server.module.data.pansmile.MessageDao;
import pro.i_it.learn.server.module.data.pansmile.UserDao;
import pro.i_it.learn.server.module.interfaces.IChatManager;
import pro.i_it.learn.server.module.interfaces.ISender;

import java.util.ArrayList;

/**
 *
 */
public class ChatManager implements IChatManager {
    private ArrayList<ISender> senders;
    private MessageDao messageDao;

    public ChatManager() {
        senders = new ArrayList<>();
    }

    private void initMessageDao() {
        if (messageDao == null) {
            messageDao = (MessageDao) ModuleManager.getModuleManager().getDataManager().getMessageDao();
        }
    }


    @Override
    public void inputMessage(MessageModel model) {
        initMessageDao();
        messageDao.saveData(model);
        senders.forEach(sender -> sender.sendAll(model));

    }


    @Override
    public void putSender(ISender sender) {
       senders.add(sender);

    }

    @Override
    public ArrayList<MessageModel> getHistory() {
        initMessageDao();
        return messageDao.getAllData();
    }
}
