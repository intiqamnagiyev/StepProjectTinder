package servlet;

import filter.Session;
import model.Message;
import model.User;
import service.MessageService;
import service.UserService;

import javax.servlet.ServletException;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        final int id = Integer.parseInt(req.getParameter("id"));
        final List<Message> messages = messageService.get(Session.getUser().getId(), id);

        Optional<User> optionalUser =userService.get(id);
        final HashMap<String, Object> data = new HashMap<>();
        data.put("messages", messages);
        optionalUser.ifPresent(op->{
            data.put("writeToUser",optionalUser.get());

            data.put("id", id);
        });
        engine.render("chat.ftl", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        final String message = req.getParameter("message");
        final int id = Integer.parseInt(req.getParameter("id"));
        if (!message.isEmpty()) {
            System.out.println(message);
            final long lastMessageId = messageService.save(message, Session.getUser().getId(), id);
        }

        resp.sendRedirect("/messages?id=" + id);

    }
}
