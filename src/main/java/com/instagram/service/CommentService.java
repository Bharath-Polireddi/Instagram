package com.instagram.service;

import com.instagram.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getComments(Integer postId);

    Integer getCommentsCount(Integer postId);
}
