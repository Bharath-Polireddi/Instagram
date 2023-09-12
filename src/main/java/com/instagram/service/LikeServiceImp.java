package com.instagram.service;

import com.instagram.repo.ImageRepo;
import com.instagram.repo.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImp implements LikeService {

    @Autowired
    LikeRepo likeRepo;

    public Integer noOfLikes(Integer postId){
        return likeRepo.noOfLikes(postId);
    }
}
