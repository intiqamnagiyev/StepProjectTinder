package servlet;

import entity.User;
import service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LikedServlet extends HttpServlet {
    private UserService userService;
    private TemplateEngine engine;

    public LikedServlet(UserService userService, TemplateEngine engine) {
        this.userService = userService;
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<User> userList = userService.getLikedUsersList(Session.getUser().getId());
        if (!userList.isEmpty()) {
            final Map<String, Object> data = new HashMap<>();
            data.put("userlist", userList);
            engine.render("people-list.ftl", data, resp);
        } else resp.sendRedirect("/users");


    }

}
