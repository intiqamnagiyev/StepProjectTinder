package servlet;

import entity.User;
import service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class UsersServlet extends HttpServlet {
    private final UserService userService;
    private final TemplateEngine engine;

    public UsersServlet(UserService userService, TemplateEngine engine) {
        this.userService = userService;
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        final HashMap<String, Object> data = new HashMap<>();

        Optional<User> optionalUser = userService.getUserToShow(Session.getUser().getId());

        if (!optionalUser.isPresent()) {
            resp.sendRedirect("/liked");
        } else {
            final User user = optionalUser.get();
            data.put("user", user);
            engine.render("like-page.ftl", data, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final int id = Integer.parseInt(req.getParameter("id"));
        final String action = req.getParameter("action");

        if (action.equalsIgnoreCase("like")) {
           userService.like(Session.getUser().getId(),id);
        }
        resp.sendRedirect("/users");
    }
}
