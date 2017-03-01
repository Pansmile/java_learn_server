package pro.i_it.learn.server.servlet;

import pro.i_it.learn.server.model.HelloModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by syn on 01.03.17.
 */
@WebServlet("/")
public class HelloWorldServlet extends HttpServlet {
    private HelloModel helloModel;

    @Override
    public void init() throws ServletException {
        super.init();
        helloModel = new HelloModel();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println(helloModel.toString());
    }
}
