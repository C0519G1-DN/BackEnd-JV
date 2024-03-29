package com.smile.mp3dao.entity;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smile.mp3common.validation.Unique;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user0")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_user", length = 50)
    private String name;

    private int age;

    private String gender;

    private String phone;


    @Column(length = 50)
//    @Unique(message = "Email is already exit")

    private String email;

    @Column(name = "user_name", length = 50)
//    @Unique(message = "Username is already exit")
    private String username;

    @JsonIgnore
    @Column(length = 200)
    private String password;

    private Boolean delected;


    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Comment> comments;

//    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
//    private Set<LikeSong> likeSongs;

    public User() {
    }

    public User(int id, String name, int age, String gender, String phone, String email, String username, String password, Boolean delected) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.delected = delected;
    }
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


//    public Set<LikeSong> getLikeSongs() {
//        return likeSongs;
//    }
//
//    public void setLikeSongs(Set<LikeSong> likeSongs) {
//        this.likeSongs = likeSongs;
//    }


    @Override
    public String toString() {
        return getAge() + getId() + getEmail() + getName() + getUsername() + getGender() +
                getDelected() +
                getPassword() + getPhone();
    }
}
