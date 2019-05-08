package com.launchcode.cheesemvc.Model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Email
    @NotNull
    private String email;

    @Size(min=3,max = 15, message = "enter userName")
    @NotNull
    private String username;

    @Size(min=3,max = 15, message = "enter pwd")
    @NotNull
    private String password;

    public User() {

    }

//    public boolean doesVerifyMatchPassword) {
//
//        if(this.password == null || this.verify == null){
//            return;
//        }
//
//
//
//        return this.password.equals(verify);
//    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {

        //check if pwd matches verify
        //assuming pwd is set before verify
        //if it does not match set verify to null


        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
