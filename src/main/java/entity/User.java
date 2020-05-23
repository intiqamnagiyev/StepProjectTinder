package entity;

import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class User {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String job;
    private LocalDateTime lastLogin;
    private String password;
    private String dayAgo;
    private String photoLink;


    public User(String name, String surname, String photo, String job, String email, String password) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.job = job;
        this.password = password;
        this.photoLink = photo;
    }


}
