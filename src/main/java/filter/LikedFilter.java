package filter;

import servlet.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LikedFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig)  {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (Session.getUser()!=null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else  response.sendRedirect("/login");
    }

    @Override
    public void destroy() {

    }
}
