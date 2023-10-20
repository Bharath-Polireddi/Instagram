package com.instagram.rest;

import com.instagram.model.Comment;
import com.instagram.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/user/comments/{postId}")
    @Operation(summary = "get the list of comments of a particular post")
    public List<Comment> getComments(@PathVariable("postId") Integer PostId){
        return  commentService.getComments(PostId);
    }

    @GetMapping("/user/comments-count/{postId}")
    @Operation(summary = "get the total number of comments of a post")
    public String getCommentsCount(@PathVariable("postId") Integer postId){
        Integer count =   commentService.getCommentsCount(postId);
        return count + "  comments" ;
    }
}
