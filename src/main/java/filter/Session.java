package filter;

import model.User;

public class Session {
    private static User user = null;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Session.user = user;

    }
}
