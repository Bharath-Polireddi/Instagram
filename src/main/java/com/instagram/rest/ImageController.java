package com.instagram.rest;

import com.instagram.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @Autowired
    ImageService imagesService;

    @GetMapping("/user/noOfImages/{userId}/{postId}")
    @Operation(summary = "get the number of images posted by user in specific post")
    public Integer imagesCount(@PathVariable("userId") Integer userId, @PathVariable("postId") Integer postId){
        return imagesService.noOfImages(userId, postId);
    }
}
