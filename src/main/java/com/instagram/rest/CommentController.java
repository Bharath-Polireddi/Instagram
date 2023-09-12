package com.instagram.rest;

import com.instagram.entities.Comment;
import com.instagram.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comments/{postId}")
    @Operation(summary = "get the list of comments of a particular post")
    public Comment getComments(@PathVariable("postId") Integer PostId){
        return commentService.getComments(PostId);
    }
}
