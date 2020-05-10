package sql;

public class SqlQuerry {
    public static final String GET_UNLIKED_USERS="select w.id , w.name,w.surname,w.job, w.last_login, null as password, " +
            " null as day , w.email from liked l  " +
            " right join   users u on l.who_id=?  " +
            " right join  users w on w.id=l.whom_id  " +
            " where u.id is null and w.id <> ?  ";

    public static final String GET_USER_BY_EMAIL="select *, null as day from " +
            "users where email= ?";

    public static final String GET_ALL_LIKED_USERS= " select w.id,w.name, w.surname, u.job,u.last_login,null as email, null as password, DATE_PART('day', now() - w.last_login)  as day from liked l " +
            "join users u on u.id=l.who_id  " +
            "join users w on l.whom_id=w.id  " +
            "where l.who_id=? ";
}
