package pro.i_it.learn.server.servlet;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import io.netty.channel.unix.Socket;
import pro.i_it.learn.server.model.HelloModel;
import pro.i_it.learn.server.model.MessageModel;
import pro.i_it.learn.server.model.UserModel;
import pro.i_it.learn.server.module.ModuleManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;

/**
 * Created by syn on 01.03.17.
 */
@WebServlet("/")
public class HelloWorldServlet extends HttpServlet {
    private HelloModel helloModel;
    private ModuleManager moduleManager;

    @Override
    public void init() throws ServletException {
        super.init();
        helloModel = new HelloModel();
        moduleManager =  ModuleManager.getModuleManager();


    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println(helloModel.toString());
        ArrayList<MessageModel> allMessage = moduleManager.getDataManager().getMessageDao().getAllData();
        for (MessageModel messageModel : allMessage) {
            resp.getWriter().println(messageModel.getFrom() + " : " + messageModel.getMessage());
        }
        ArrayList<UserModel> allUsers = moduleManager.getDataManager().getUserDao().getAllData();
        for (UserModel userModel : allUsers) {
            resp.getWriter().println(userModel.getNik());
        }

    }



}
