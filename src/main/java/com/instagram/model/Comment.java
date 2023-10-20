package com.instagram.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private  int commentId;

    private  String comment;

    private Integer postId;
    private Integer userId;


    @Column(name ="commented_at")
    private LocalDateTime commentedAt;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", insertable = false,updatable = false)
    @JsonIgnore
    private Post postCommented;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }



    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(LocalDateTime commentedAt) {
        this.commentedAt = commentedAt;
    }


    public Post getPostCommented() {
        return postCommented;
    }

    public void setPostCommented(Post postCommented) {
        this.postCommented = postCommented;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

