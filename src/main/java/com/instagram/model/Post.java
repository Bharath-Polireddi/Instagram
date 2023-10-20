package com.instagram.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int postId;

    private  Integer userId;

    private String caption;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", insertable = false,updatable = false)
    @JsonIgnore
    private User postUser;

    @OneToMany(mappedBy = "postImages")
    @JsonIgnore
    private List<Media> postedMedia = new ArrayList<Media>();

    @OneToMany(mappedBy = "postLiked")
    @JsonIgnore
    private List<Like> likedPosts = new ArrayList<Like>();

    @OneToMany(mappedBy = "postCommented")
    @JsonIgnore
    private List<Comment> commentedPosts = new ArrayList<Comment>();

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getPostUser() {
        return postUser;
    }

    public void setPostUser(User postUser) {
        this.postUser = postUser;
    }

    public List<Media> getPostedImages() {
        return postedMedia;
    }

    public void setPostedImages(List<Media> postedMedia) {
        this.postedMedia = postedMedia;
    }

    public List<Like> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(List<Like> likedPosts) {
        this.likedPosts = likedPosts;
    }

    public List<Comment> getCommentedPosts() {
        return commentedPosts;
    }

    public void setCommentedPosts(List<Comment> commentedPosts) {
        this.commentedPosts = commentedPosts;
    }
}
