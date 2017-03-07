package pro.i_it.learn.server.module.data.pansmile;

import pro.i_it.learn.server.model.UserModel;
import pro.i_it.learn.server.module.data.interfaces.IDao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pansmile on 04.03.17.
 */
public class UserDao implements IDao<UserModel> {
    private HashMap<Integer, UserModel> users;

    public UserDao() {
        users = new HashMap<>();
    }
    @Override
    public UserModel getDataById(int id) {
        return users.get(id);
    }

    @Override
    public void saveData(UserModel userModel) {
        users.put(userModel.getId(), userModel);
    }

    @Override
    public ArrayList<UserModel> getAllData() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void deleteData(UserModel userModel) {
        users.remove(userModel.getId());
    }
}
