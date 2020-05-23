package servlet;

import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Session.setUser(null);
        String content = new BufferedReader(new FileReader(new File("templates/login.html"))).lines()
                .collect(Collectors.joining("\n"));
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(content);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*final Cookie[] cookies = req.getCookies();
        for(Cookie c: cookies){
            System.out.printf("name:%s, value:%s\n",c.getName(), c.getValue());
        }*/
        resp.sendRedirect("/me");
    }
}
