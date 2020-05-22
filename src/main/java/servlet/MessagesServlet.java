package servlet;

import entity.Message;
import entity.User;
import service.MessageService;
import service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MessagesServlet extends HttpServlet {
    private final TemplateEngine engine;
    private final MessageService messageService;
    private final UserService userService;

    public MessagesServlet(TemplateEngine engine, MessageService messageService, UserService userService) {
        this.engine = engine;
        this.messageService = messageService;
        this.userService = userService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        final int id = Integer.parseInt(req.getParameter("id"));

        boolean valid = userService.checkPermission(Session.getUser().getId(), id);

        if (valid) {
            Optional<User> optionalUser = userService.get(id);
            final HashMap<String, Object> data = new HashMap<>();
            final List<Message> messages = messageService.getAll(Session.getUser().getId(), id);
            data.put("messages", messages);
            if (optionalUser.isPresent()) {
                data.put("writeToUser", optionalUser.get());
                data.put("id", id);
                engine.render("chat.ftl", data, resp);
            } else {
                resp.sendRedirect("/liked");
            }
        } else resp.sendRedirect("/liked");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String message = req.getParameter("message");
        final int id = Integer.parseInt(req.getParameter("id"));

        if (!message.isEmpty()) {
            System.out.println(message);
            messageService.save(message, Session.getUser().getId(), id);
        }

        resp.sendRedirect("/messages?id=" + id);

    }
}
