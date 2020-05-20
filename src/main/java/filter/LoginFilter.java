package filter;


import entity.User;
import service.UserService;
import servlet.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class LoginFilter implements Filter {
    private final UserService userService;


    public LoginFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;


        if (request.getMethod().equalsIgnoreCase("POST")) {
            final Optional<User> userWithEmail = userService.getUserByEmail(request.getParameter("email"));


            if (userWithEmail.isPresent() && userWithEmail.get().getPassword().equalsIgnoreCase(request.getParameter("password"))) {
            /*   final Cookie cookie = new Cookie("id",UUID.randomUUID().toString());
                response.addCookie(cookie);*/
                Session.setUser(userWithEmail.get());
                filterChain.doFilter(servletRequest, servletResponse);

            } else {
                response.sendRedirect("/login");
            }
        } else filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
