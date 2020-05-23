package servlet;

import lombok.AllArgsConstructor;
import service.MessageService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class ResetServlet extends HttpServlet {
    private final UserService userService;
    private final MessageService messageService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.reset();
        messageService.reset();
        resp.sendRedirect("/users/");
    }
}
