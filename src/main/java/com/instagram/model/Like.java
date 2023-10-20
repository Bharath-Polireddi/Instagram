package com.instagram.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private  int likeId;

    private  Integer postId;


    @Column(name ="liked_at")
    private LocalDateTime likedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="userId")
    private User likedUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", insertable = false, updatable = false)
    private Post postLiked;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public User getLikedUser() {
        return likedUser;
    }

    public void setLikedUser(User likedUser) {
        this.likedUser = likedUser;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public LocalDateTime getLikedAt() {
        return likedAt;
    }

    public void setLikedAt(LocalDateTime likedAt) {
        this.likedAt = likedAt;
    }

    public User getLikedUserId() {
        return likedUser;
    }

    public void setLikedUserId(User likedUserId) {
        this.likedUser = likedUserId;
    }

    public Post getPostLiked() {
        return postLiked;
    }

    public void setPostLiked(Post postLiked) {
        this.postLiked = postLiked;
    }
}
