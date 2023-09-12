package com.instagram.service;

import com.instagram.entities.Comment;

public interface CommentService {
    Comment getComments(Integer postId);
}
