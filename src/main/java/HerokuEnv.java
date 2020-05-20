

public class HerokuEnv {

    public static int port() {
        try {
            return Integer.parseInt(System.getenv("PORT"));
        } catch (NumberFormatException ex) {
            return 5000;
        }
    }

    public static String jdbc_url() {
        String url = System.getenv("JDBC_DATABASE_URL");
        if (url == null) throw new IllegalArgumentException("JDBC_DATABASE_URL is empty!!!");
        return url;
    }

    public static String jdbc_username() {
        String username = System.getenv("JDBC_DATABASE_USERNAME");
        if (username == null) throw new IllegalArgumentException("JDBC_DATABASE_USERNAME is empty!!!");
        return username;
    }

    public static String jdbc_password() {
        String password = System.getenv("JDBC_DATABASE_PASSWORD");
        if (password == null) throw new IllegalArgumentException("JDBC_DATABASE_PASSWORD is empty!!!");
        return password;
    }

}
