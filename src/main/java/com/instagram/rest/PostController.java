package com.instagram.rest;

import com.instagram.model.Post;
import com.instagram.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @Operation(summary = "list all the posts of a given user")
    @GetMapping("/user/posts/{id}")
    public List<Post> getAllPosts(@PathVariable("id") Integer id){
        return postService.getPosts(id);
    }

    @Operation(summary = "delete the post by taking input userId")
    @DeleteMapping("/user/remove/post/{id}")
    public String deletePost(@PathVariable("id") Integer id){
        return postService.deletePost(id);
    }

    @Operation(summary = "update caption of the post")
    @PutMapping ("/user/caption/{id}/{caption}")
    public Post updatePost(@PathVariable("id") Integer id, @PathVariable("caption") String caption){
      return postService.updatePost(id, caption);
    }
    @Operation(summary = "create new post ")
    @PostMapping("/user/new/post")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @Operation(summary = "get the number of posts of a user")
    @GetMapping("/no-of-Posts/{id}")
    public Integer postsCount(@PathVariable("id") Integer userId){
        return  postService.noOfPosts(userId);
    }



}
