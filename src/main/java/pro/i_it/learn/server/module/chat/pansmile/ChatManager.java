package pro.i_it.learn.server.module.chat.pansmile;

import pro.i_it.learn.server.model.MessageModel;
import pro.i_it.learn.server.module.ModuleManager;
import pro.i_it.learn.server.module.interfaces.IChatManager;
import pro.i_it.learn.server.module.interfaces.ISender;

import java.util.ArrayList;

/**
 *
 */
public class ChatManager implements IChatManager {
    private ArrayList<ISender> senders;

    public ChatManager() {
        senders = new ArrayList<>();
    }



    @Override
    public void inputMessage(MessageModel model) {
        ModuleManager.getModuleManager().getDataManager().getMessageDao().saveData(model);
        senders.forEach(sender -> sender.sendAll(model));

    }


    @Override
    public void putSender(ISender sender) {
       senders.add(sender);

    }

    @Override
    public ArrayList<MessageModel> getHistory() {
        return ModuleManager.getModuleManager().getDataManager().getMessageDao().getAllData();
    }
}
