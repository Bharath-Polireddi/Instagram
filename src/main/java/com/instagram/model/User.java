package com.instagram.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="users")
@NoArgsConstructor
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @Column(name = "name")
    private String fullName;

    private String email;

    @Column(name = "username")
    private String userName;
    private String password;

    private String role;

    public User(int userId, String email, String userName, String password, String role) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    @OneToMany(mappedBy = "postUser")
    @JsonIgnore
    private List<Post> userPosts = new ArrayList<Post>();

    @OneToMany(mappedBy = "imageUser")
    @JsonIgnore
    private List<Media> userMedia = new ArrayList<Media>();

    @OneToMany(mappedBy = "likedUser")
    @JsonIgnore
    private List<Like> userLikes = new ArrayList<Like>();



    @OneToMany(mappedBy = "mainUser")
    @JsonIgnore
    private List<Follow> user = new ArrayList<Follow>();


    @OneToMany(mappedBy = "followingUser")
    @JsonIgnore
    private List<Follow> followers = new ArrayList<Follow>();




    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public List<Post> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(List<Post> userPosts) {
        this.userPosts = userPosts;
    }
    @JsonIgnore
    public List<Media> getUserImages() {
        return userMedia;
    }
@JsonIgnore
    public void setUserImages(List<Media> userMedia) {
        this.userMedia = userMedia;
    }

    public List<Like> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<Like> userLikes) {
        this.userLikes = userLikes;
    }



    public List<Follow> getUser() {
        return user;
    }

    public void setUser(List<Follow> user) {
        this.user = user;
    }

    public List<Follow> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follow> followers) {
        this.followers = followers;
    }
}
