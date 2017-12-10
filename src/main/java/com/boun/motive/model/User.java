package com.boun.motive.model;

import com.boun.motive.util.constant.Privacy;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class User implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8408001540902678520L;

	@Id
    private String id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String accountType;

    @NotNull
    private String accountStatus;

    private Privacy accountPrivacy;

    public User()
    {

    }

    public User(String id, String username, String password, String email, String accountType, String accountStatus, Privacy accountPrivacy) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.accountPrivacy = accountPrivacy;
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

    public Privacy getAccountPrivacy() {
        return accountPrivacy;
    }

    public void setAccountPrivacy(Privacy accountPrivacy) {
        this.accountPrivacy = accountPrivacy;
    }
}
