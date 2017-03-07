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
    private ModuleManager moduleManager;
    private ArrayList<ISender> senders;

    public ChatManager() {
        senders = new ArrayList<>();
    }



    @Override
    public void inputMessage(MessageModel model) {
        moduleManager.getDataManager().getMessageDao().saveData(model);
        for (ISender sender : senders) {
            sender.sendAll(model);
        }

    }


    @Override
    public void putSender(ISender sender) {
       senders.add(sender);

    }

    @Override
    public ArrayList<MessageModel> getHistory() {
        if (moduleManager == null) {
            moduleManager = ModuleManager.getModuleManager();
        }
        return moduleManager.getDataManager().getMessageDao().getAllData();
    }
}
