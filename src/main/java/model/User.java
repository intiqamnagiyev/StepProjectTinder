package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String job;
    private LocalDateTime lastLogin;
    private String password;
    private String dayAgo;

    public User() {
    }

    public User(long id, String name, String surname, String email, String job, LocalDateTime lastLogin, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.job = job;
        this.lastLogin = lastLogin;
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email);
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', surname='%s', email='%s', job='%s', lastLogin=%s, password='%s'}", id, name, surname, email, job, lastLogin, password);
    }
}
