package pro.i_it.learn.server.servlet;

import pro.i_it.learn.server.model.HelloModel;
import pro.i_it.learn.server.model.MessageModel;
import pro.i_it.learn.server.model.UserModel;
import pro.i_it.learn.server.module.ModuleManager;
import pro.i_it.learn.server.module.dataManager.pansmile.DataManager;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by syn on 01.03.17.
 */
@WebServlet("/")
public class HelloWorldServlet extends HttpServlet {
    private HelloModel helloModel;
    private DataManager dataManager;

    @Override
    public void init() throws ServletException {
        super.init();
        helloModel = new HelloModel();
        dataManager = (DataManager) ModuleManager.getModuleManager().getDataManager();

    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println(helloModel.toString());
        ArrayList<MessageModel> allMessage = dataManager.getMessageDao().getAllData();
        for (MessageModel messageModel : allMessage) {
            resp.getWriter().println(messageModel.getFrom() + " : " + messageModel.getMessage());
        }
        ArrayList<UserModel> allUsers = dataManager.getUserDao().getAllData();
        for (UserModel userModel : allUsers) {
            resp.getWriter().println(userModel.getNik());
        }

    }



}
