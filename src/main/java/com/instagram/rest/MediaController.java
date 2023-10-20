package com.instagram.rest;

import com.instagram.service.MediaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class MediaController {

    @Autowired
    MediaService mediaService;

    @GetMapping("/user/no-of-images/{userId}/{postId}")
    @Operation(summary = "get the number of images posted by user in specific post")
    public Integer imagesCount(@PathVariable("userId") Integer userId, @PathVariable("postId") Integer postId){
        return mediaService.noOfImages(userId, postId);
    }

    @PostMapping("/media/upload/ToDirectory")
    @Operation(summary = "save the media in system storage")
    public ResponseEntity<?> uploadMediaToDirectory(@RequestParam("image") MultipartFile file, @RequestParam("userId") Integer userId, @RequestParam("postId") Integer postId) throws IOException{
        String media = mediaService.uploadMedia(file,  postId, userId);
        return ResponseEntity.status(HttpStatus.OK).body(media);
    }

    @GetMapping("/media/retrieve/FromDirectory/{filename}")
    @Operation(summary = "retrieve the media from the system storage ")
    public ResponseEntity<?> downloadMediaFromDirectory(@PathVariable String filename) throws IOException {
        byte [] mediaData = mediaService.downloadMedia(filename);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(mediaData);

    }



}
