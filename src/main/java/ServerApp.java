import filter.LikedFilter;
import filter.LoginFilter;
import filter.MessagesFilter;
import filter.UsersFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import repository.impl.MessageRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.impl.MessageServiceImpl;
import service.impl.UserServiceImpl;
import servlet.*;
import support.StaticContentServlet;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class ServerApp {

    private static final EnumSet<DispatcherType> ft = EnumSet.of(DispatcherType.REQUEST);

    public static void main(String[] args) throws Exception {
        Server server = new Server(HerokuEnv.port());
        ServletContextHandler handler = new ServletContextHandler();

        TemplateEngine engine = TemplateEngine.folder("./templates");

        handler.addServlet(new ServletHolder(new StaticContentServlet("./templates")), "/static/*");

        handler.addServlet(new ServletHolder(new LoginServlet()), "/login/*");
        handler.addServlet(new ServletHolder(new LikedServlet(new UserServiceImpl(new UserRepositoryImpl()), engine)), "/liked/*");
        handler.addServlet(new ServletHolder(new UsersServlet(new UserServiceImpl(new UserRepositoryImpl()), engine)), "/users/*");
        handler.addServlet(new ServletHolder(new MessagesServlet(engine, new MessageServiceImpl(new MessageRepositoryImpl()), new UserServiceImpl(new UserRepositoryImpl()))), "/messages/*");
        handler.addServlet(LogoutServlet.class, "/logout/*");
        handler.addServlet(new ServletHolder(new RegisterServlet(new UserServiceImpl(new UserRepositoryImpl()))), "/register/*");

        handler.addFilter(new FilterHolder(new LoginFilter(new UserServiceImpl(new UserRepositoryImpl()))), "/login/*", ft);
        handler.addFilter(LikedFilter.class, "/liked/*", ft);
        handler.addFilter(MessagesFilter.class, "/messages/*", ft);
        handler.addFilter(UsersFilter.class, "/users/*", ft);


   /*
    handler.addServlet(UploadServlet.class, "/upload/*")
        .getRegistration().setMultipartConfig(new MultipartConfigElement("./from_user"));*/

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
