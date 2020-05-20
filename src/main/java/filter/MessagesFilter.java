package filter;

import servlet.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessagesFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig)  {


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (Session.getUser()!=null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else  response.sendRedirect("/login");
    }

    @Override
    public void destroy() {

    }
}
