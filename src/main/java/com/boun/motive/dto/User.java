package com.boun.motive.dto;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class User implements Serializable{

    @Id
    public String id;

    @NotNull
    public String username;

    @NotNull
    public String password;

    @NotNull
    public String email;

    @NotNull
    public String accountType;

    @NotNull
    public String accountStatus;

    public User()
    {

    }

    public User(String id, String username, String password, String email, String accountType, String accountStatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
