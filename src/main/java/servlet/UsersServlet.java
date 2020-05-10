package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsersServlet extends HttpServlet {
    private UserService userService;
    private TemplateEngine engine;

    public UsersServlet(UserService userService, TemplateEngine engine) {
        this.userService = userService;
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final HashMap<String, Object> data = new HashMap<>();

        Optional<User> optionalUser= userService.getUnlikedUser();
        if (optionalUser.isEmpty()){
            resp.sendRedirect("/liked");
        }else {
            final User user = optionalUser.get();
            engine.render("like-page.ftl", data, resp);
        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        // todo add user liked userService


        resp.sendRedirect("users/");
    }
}
