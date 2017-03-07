package pro.i_it.learn.server.module.data.pansmile;

import pro.i_it.learn.server.model.MessageModel;
import pro.i_it.learn.server.module.data.interfaces.IDao;

import java.util.ArrayList;

/**
 * Created by pansmile on 04.03.17.
 */
public class MessageDao implements IDao<MessageModel> {
    private ArrayList<MessageModel> history;

    public MessageDao() {
        history = new ArrayList<>();
    }

    @Override
    public MessageModel getDataById(int id) {
        for (MessageModel model : history) {
            if (model.getId() == id) {
                return model;
            }
        }

        return null;
    }

    @Override
    public void saveData(MessageModel messageModel) {
        if (history.size() < 1000) {
            history.add(messageModel);
        } else {
           history.remove(0);
           history.add(messageModel);
        }
    }

    @Override
    public ArrayList<MessageModel> getAllData() {
        return history;
    }

    @Override
    public void deleteData(MessageModel messageModel) {
        history.remove(messageModel);
    }
}
