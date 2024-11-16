package com.auth_service.auth_service.models;

import java.time.LocalDateTime;


public class userRegisterModel {

    private boolean isNewUser;

    private boolean isPasswordSet=false;

    private String _id;
    private String number;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    private String parole;
    private String name;
    private boolean isActive;

    public userRegisterModel(boolean isNewUser, boolean isPasswordSet, String _id, String email, LocalDateTime createdAt,
            LocalDateTime updatedAt, String number , String parole , String name, boolean isActive) {
        this.isNewUser = isNewUser;
        this.isPasswordSet = isPasswordSet;
        this._id = _id;
        this.email = email;
        this.number = number;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.parole = parole;
        this.name=name;
        this.isActive = isActive;

        

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isIsPasswordSet() {
        return isPasswordSet;
    }

    public void setIsPasswordSet(boolean isPasswordSet) {
        this.isPasswordSet = isPasswordSet;
    }

    public boolean isNewUser() {
        return isNewUser;
    }

    public void setNewUser(boolean isNewUser) {
        this.isNewUser = isNewUser;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPassword() {
        return parole;
    }

    public void setPassword(String Password) {
        this.parole = Password;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


}
