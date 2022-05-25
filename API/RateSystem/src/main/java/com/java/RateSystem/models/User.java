package com.java.RateSystem.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rate_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer UserId;
    private String UserName;

    private String Password;
    private String Email;
    private String Role;

    public User() {
    }

    public User(String userName, String email, String role) {
        UserName = userName;
        Email = email;
        Role = role;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(UserId, user.UserId) && Objects.equals(UserName, user.UserName) && Objects.equals(Password, user.Password) && Objects.equals(Email, user.Email) && Objects.equals(Role, user.Role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserId, UserName, Password, Email, Role);
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", Email='" + Email + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
