package pro.i_it.learn.server.model;

/**
 * Created by syn on 02.03.17.
 */
public class UserModel {
    private static int GLOBAL_ID = 0;
    private int id;
    private String nik;

    public UserModel(String nik) {
        id = GLOBAL_ID++;
        this.nik = nik;
    }

    public int getId() {
        return id;
    }

    public String getNik() {
        return nik;
    }
}
