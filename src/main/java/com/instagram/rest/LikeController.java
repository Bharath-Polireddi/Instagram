package com.instagram.rest;

import com.instagram.service.LikeService;
import com.instagram.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class LikeController {
    @Autowired
    LikeService likeService;




    @GetMapping("/likes-count/{PostId}")
    @Operation(summary = "get the number of users liked a post")
    public Integer getLikesCount(@PathVariable("PostId") Integer postId){
        return likeService.noOfLikes(postId);
    }
}
