package com.instagram.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @Column(name = "full_name")
    private String fullName;

    private String email;
    private String password;
    private String username;

    private String bio;

    @Column(name = "followers_count")
    private Integer followersCount;

    @Column(name = "following_count")
    private Integer followingCount;

    @Column(name = "profile_pic_url")
    private String picture;

    @OneToMany(mappedBy = "postUser")
    @JsonIgnore
    private List<Post> userPosts = new ArrayList<Post>();

    @OneToMany(mappedBy = "imageUser")
    private List<Image> userImages = new ArrayList<Image>();

    @OneToMany(mappedBy = "likedUser")
    private List<Like> userLikes = new ArrayList<Like>();

    @OneToMany(mappedBy = "commentUser")
    private List<Comment> userComments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "mainUser")
    private List<Follow> user = new ArrayList<Follow>();


    @OneToMany(mappedBy = "followingUser")
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Post> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(List<Post> userPosts) {
        this.userPosts = userPosts;
    }

    public List<Image> getUserImages() {
        return userImages;
    }

    public void setUserImages(List<Image> userImages) {
        this.userImages = userImages;
    }

    public List<Like> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<Like> userLikes) {
        this.userLikes = userLikes;
    }

    public List<Comment> getUserComments() {
        return userComments;
    }

    public void setUserComments(List<Comment> userComments) {
        this.userComments = userComments;
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
