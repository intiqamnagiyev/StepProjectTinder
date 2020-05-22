package servlet;

import entity.User;
import service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class RegisterServlet extends HttpServlet {
    private final UserService userService;

    public RegisterServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String content = new BufferedReader(new FileReader(new File("templates/index.html")))
                .lines().collect(Collectors.joining("\n"));
        try (final PrintWriter writer = resp.getWriter()) {
            writer.write(content);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String name = req.getParameter("name");
        final String surName = req.getParameter("surname");
        final String photo = req.getParameter("photo");
        final String job = req.getParameter("job");
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");
        final User user = new User(name, surName, photo, job, email, password);

        userService.save(user);
        resp.sendRedirect("/login");

    }
}