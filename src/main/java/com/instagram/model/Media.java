package com.instagram.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="images")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private  int id;

    private  String mediaType;

    private String name;
 //@Column(name = "media_path")
    private String mediaPath;

    private Integer postId;

    private Integer userId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="userId", insertable = false, updatable = false)
    @JsonIgnore
    private User imageUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", insertable = false, updatable = false)
    @JsonIgnore
    private Post postImages;



}
