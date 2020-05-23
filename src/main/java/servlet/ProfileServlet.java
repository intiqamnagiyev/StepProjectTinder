package servlet;

import entity.User;
import lombok.AllArgsConstructor;
import service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Optional;

@AllArgsConstructor
public class ProfileServlet extends HttpServlet {
    private final UserService userService;
    private final TemplateEngine engine;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Optional<User> optionalUser = userService.get(Session.getUser().getId());
        optionalUser.ifPresent(u -> {
            final HashMap<String, Object> data = new HashMap<>();
            final User user = optionalUser.get();
            data.put("user", user);
            engine.render("profile.ftl", data, resp);
        });
    }
}
