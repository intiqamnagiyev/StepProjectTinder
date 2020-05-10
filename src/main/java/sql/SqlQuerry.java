package sql;

public class SqlQuerry {
    public static final String GET_UNLIKED_USERS="select w.id , w.name,w.surname,w.job, w.last_login, null as password , w.email from liked l  " +
            " right join   users u on l.who_id=?  " +
            " right join  users w on w.id=l.whom_id  " +
            " where u.id is null and w.id <> ?  ";

    public static final String GET_USER_BY_EMAIL="select * from " +
            "users where email= ?";
}
