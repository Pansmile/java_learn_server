package pro.i_it.learn.server.model;

/**
 * Created by syn on 02.03.17.
 */
public class MessageModel {
    private static int GLOBAL_ID = 0;
    private int id;
    private String from;
    private String message;

    public MessageModel() {
        id = GLOBAL_ID++;
    }

    public MessageModel(String from, String message) {
        super();
        this.from = from;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFrom() {
        return from;
    }


    public int getId() {
        return id;
    }
}
