import dao.MessageDao;
import dao.UserDao;
import db.ConnDetails;
import db.DbConn;
import db.DbSetup;
import filter.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import service.MessageService;
import service.UserService;
import servlet.*;
import support.StaticContentServlet;

import javax.servlet.DispatcherType;
import java.sql.Connection;
import java.util.EnumSet;
public class TinderApp {
    private static final EnumSet<DispatcherType> ft = EnumSet.of(DispatcherType.REQUEST);

    public static void main(String[] args) throws Exception {
        DbSetup.migrate(ConnDetails.url, ConnDetails.username, ConnDetails.password);
      Connection connection = DbConn.create(ConnDetails.url, ConnDetails.username, ConnDetails.password);

      //DbSetup.migrate(HerokuEnv.jdbc_url(), HerokuEnv.jdbc_username(), HerokuEnv.jdbc_password());
        //Connection connection = DbConn.createFromURL(HerokuEnv.jdbc_url(), HerokuEnv.jdbc_username(), HerokuEnv.jdbc_password());

        Server server = new Server(HerokuEnv.port());
        TemplateEngine engine = TemplateEngine.folder("./templates");

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new StaticContentServlet("./templates")), "/static/*");
        handler.addServlet(new ServletHolder(new RegisterServlet(new UserService(new UserDao(connection)))), "/register");
        handler.addServlet(LoginServlet.class, "/login/*");
        handler.addServlet(new ServletHolder(new UsersServlet(new UserService(new UserDao(connection)), engine)), "/users");
        handler.addServlet(new ServletHolder(new LikedServlet(new UserService(new UserDao(connection)), engine)), "/liked");
        handler.addServlet(new ServletHolder(new MessagesServlet(engine,
                new MessageService(new MessageDao(connection)),
                new UserService(new UserDao(connection)))), "/messages");
        handler.addServlet(LogoutServlet.class, "/logout");
        handler.addServlet(new ServletHolder(new ProfileServlet(new UserService(new UserDao(connection)),engine)),"/me");

        handler.addFilter(new FilterHolder(new LoginFilter(new UserService(new UserDao(connection)))), "/login/*", ft);
        handler.addFilter(new FilterHolder(new UsersFilter()), "/users/*", ft);
        handler.addFilter(LikedFilter.class, "/liked", ft);
        handler.addFilter(MessagesFilter.class, "/messages", ft);
        handler.addFilter(ProfileFilter.class, "/me", ft);

        handler.addServlet(RedirectServlet.class, "/*");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
