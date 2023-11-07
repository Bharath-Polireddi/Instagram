package com.instagram.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="users")
@NoArgsConstructor
@Data
@AllArgsConstructor
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



}
