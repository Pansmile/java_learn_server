package pro.i_it.learn.server.module.data.interfaces;

import java.util.ArrayList;

/**
 * Created by syn on 02.03.17.
 */
public interface IDao<Data> {
    Data getDataById(int id);

    void saveData(Data data);

    ArrayList<Data> getAllData();

    void deleteData(Data data);
}
