package com.smile.mp3dao.dto;

import com.smile.mp3dao.entity.User;


import java.io.Serializable;

public class UserDTO implements Serializable {
    public UserDTO() {
    }

    public UserDTO(User original) {
        this.id= original.getId();
        this.name= original.getName();
        this.age= original.getAge();
        this.gender= original.getGender();
        this.phone= original.getPhone();
        this.username = original.getUsername();
        this.email = original.getEmail();
        this.delected= original.getDelected();
    }

    private int id;

    private String name;

    private int age;

    private String gender;

    private String phone;

    private String email;

    private String username;

    private boolean delected;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getDelected() {
        return delected;
    }

    public void setDelected(boolean delected) {
        this.delected = delected;
    }
}
