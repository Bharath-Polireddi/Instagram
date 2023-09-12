package com.instagram.service;

import com.instagram.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImp implements ImageService {
    @Autowired
    private ImageRepo imagesRepo;

    public  Integer noOfImages(Integer userId, Integer postId){
        return imagesRepo.getImagesCount(userId, postId);
    }

}
