package com.internship.blog.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
    @GeneratedValue
    @Id
    private Integer id;
    @NotBlank(message = "fullname should not be empty")
    private String fullname;
    @NotBlank(message = "email should not be empty")
    private String password;
    @NotBlank(message = "password should not be empty")
    @Email(message = "improper mail format")
    @Column(unique = true)
    private String email;

    public User() {

    }

    public User(String fullname, String password, String email) {
        this.fullname = fullname;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
