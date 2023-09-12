package com.instagram.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private  int imageId;

    @Column(name ="image_url")
    private String imageUrl;

    private Integer postId;

    private Integer userId;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getImageUser() {
        return imageUser;
    }

    public void setImageUser(User imageUser) {
        this.imageUser = imageUser;
    }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="userId", insertable = false, updatable = false)
    @JsonIgnore
    private User imageUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", insertable = false, updatable = false)
    @JsonIgnore
    private Post postImages;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getImageUserId() {
        return imageUser;
    }

    public void setImageUserId(User imageUserId) {
        this.imageUser = imageUserId;
    }

    public Post getPostImages() {
        return postImages;
    }

    public void setPostImages(Post postImages) {
        this.postImages = postImages;
    }
}
