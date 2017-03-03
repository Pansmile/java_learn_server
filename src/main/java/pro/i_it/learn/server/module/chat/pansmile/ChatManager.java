package pro.i_it.learn.server.module.chat.pansmile;

import pro.i_it.learn.server.model.MessageModel;
import pro.i_it.learn.server.module.interfaces.IChatManager;
import pro.i_it.learn.server.module.interfaces.ISender;

import java.util.ArrayList;

/**
 * This class is made to hold chat message history and for something that i didn't understood yet.
 */
public class ChatManager implements IChatManager {
    private  ArrayList<MessageModel> history = new ArrayList<>(1000);
    private int count = 0;
    private ISender sender;


    @Override
    public void inputMessage(MessageModel model) {
       /*In order to hold in memory only 1000 messages i decided to shift whole history to the left.
       * I know that this is not effective but could not imagine how to do this other way while we are using
       * an ArrayList in getHistory() method.*/

       if (count < 1000) {
           history.add(model);
           count++;
       } else {
           for (int i = 0; i < 999; i++) {
               history.set(i, history.get(i + 1));
           }
           history.set(999, model);
       }

    }

    //did not figured out what kind of job an ISender can do in this class.
    @Override
    public void putSender(ISender sender) {
        this.sender = sender;

    }

    @Override
    public ArrayList<MessageModel> getHistory() {
        return history;
    }
}
