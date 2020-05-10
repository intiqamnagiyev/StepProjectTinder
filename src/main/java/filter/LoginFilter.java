package filter;

import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class LoginFilter implements Filter {
private UserService userService;

    public LoginFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final Optional<User> userWithEmail = userService.getUserByEmail(request.getParameter("email"));
       if (request.getMethod().equalsIgnoreCase("POST")){
           if (userWithEmail.isPresent() && userWithEmail.get().getPassword().equalsIgnoreCase(request.getParameter("password"))){
               Session.setUser(userWithEmail.get());
               filterChain.doFilter(servletRequest, servletResponse);

           }else {
               response.sendRedirect("/login");
           }
       }else filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
