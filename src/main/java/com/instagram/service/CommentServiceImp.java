package com.instagram.service;


import com.instagram.entities.Comment;
import com.instagram.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImp implements CommentService{

    @Autowired
    CommentRepo commentRepo;

    public Comment getComments(Integer postId){
        return commentRepo.getComments(postId);
    }

}
