package com.smile.mp3dao.entity;

import com.smile.mp3common.validation.Unique;

import javax.persistence.*;

@Entity
@Table(name = "user0")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_user")
    private String name;

    private int age;

    private String gender;

    private String phone;

//        @Unique(message = "Email is already exit")
    private String email;

    @Column(name = "user_name")
//    @Unique(message = "Username is already exit")
    private String username;

    private String password;

    private Boolean delected;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDelected() {
        return delected;
    }

    public void setDelected(boolean delected) {
        this.delected = delected;
    }

    @Override
    public String toString() {
        return getAge() + getId() + getEmail() + getName() + getUsername() + getGender() + getDelected() + getPassword() + getPhone();
    }
}
