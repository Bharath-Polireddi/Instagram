package com.instagram.service;

import com.instagram.entities.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getComments(Integer postId);

    Integer getCommentsCount(Integer postId);
}
