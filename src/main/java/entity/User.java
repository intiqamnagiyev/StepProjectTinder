package entity;

import java.time.LocalDateTime;




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

    public User() {
    }

    public User(String name, String surname, String photo, String job, String email, String password) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.job = job;
        this.password = password;
        this.photoLink = photo;
    }

    public User(long id, String name, String surname, String email, String job, LocalDateTime lastLogin, String password, String dayAgo, String photoLink) {
        this(name, surname, photoLink, job, email, password);
        this.id = id;
        this.lastLogin = lastLogin;
        this.dayAgo = dayAgo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDayAgo() {
        return dayAgo;
    }

    public void setDayAgo(String dayAgo) {
        this.dayAgo = dayAgo;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', surname='%s', email='%s', job='%s', lastLogin=%s, password='%s', dayAgo='%s', photoLink='%s'}", id, name, surname, email, job, lastLogin, password, dayAgo, photoLink);
    }
}
