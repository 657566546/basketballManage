package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
    private int id;
    private String userName;
    @JsonIgnore
    private String isVisible;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(String isVisible) {
        this.isVisible = isVisible;
    }

    public User(int id, String userName, String isVisible) {
        this.id = id;
        this.userName = userName;
        this.isVisible = isVisible;
    }

}
