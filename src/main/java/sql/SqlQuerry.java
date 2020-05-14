package sql;

public class SqlQuerry {
    public static final String GET_DISLIKED_USER = "  select w.id , w.name,w.surname,w.job, w.last_login, null as password, w.photo,\n" +
            "                         null as day , w.email from liked l\n" +
            "                         right join   users u on l.who_id= ?\n" +
            "                         right join  users w on w.id=l.whom_id\n" +
            "                         where u.id is null and w.id <> ?\n" +
            "              order by random()\n" +
            "limit 1  ";


    public static final String GET_USER_BY_EMAIL = "select *, null as day from " +
            "users where email= ?";

    public static final String GET_ALL_LIKED_USERS = "select w.id,w.name, w.surname, w.job, w.last_login,  w.photo  ,null as email, null as password, DATE_PART('hour', now() - w.last_login)  as day from liked l " +
            "            join users u on u.id=l.who_id " +
            "            join users w on l.whom_id=w.id " +
            "            where l.who_id=? ";

    public static final String INSERT_LIKED_USER = "insert into liked (who_id, whom_id) VALUES (?,?)";

    public static final String INSERT_MESSAGE = "insert into messages (from_user, to_user, content) VALUES (?, ?, ?)";

    public static final String GET_MESSAGES = "select  * from " +
            " messages m " +
            "join users f on f.id=m.from_user " +
            "join users t on t.id= m.to_user " +
            "where m.from_user=?  and m.to_user =? or m.from_user=? and m.to_user=?  " +
            "order by insert_date";


}
