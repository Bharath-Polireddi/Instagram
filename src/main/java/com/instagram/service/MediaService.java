package com.instagram.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MediaService {

        Integer noOfImages(Integer userId, Integer postId);

        String uploadMedia(MultipartFile file, Integer postId, Integer userId) throws IOException;

        byte [] downloadMedia(String fileName) throws IOException;

}
