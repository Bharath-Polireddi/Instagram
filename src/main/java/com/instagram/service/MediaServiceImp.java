package com.instagram.service;

import com.instagram.model.Media;
import com.instagram.repo.MediaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class MediaServiceImp implements MediaService {
    @Autowired
    private MediaRepo mediaRepo;


    private  static final String FOLDER_PATH = "C:\\Users\\Bharath kumar\\InstaMedia\\";

    public  Integer noOfImages(Integer userId, Integer postId){
        return mediaRepo.getImagesCount(userId, postId);
    }

    @Override
    public String uploadMedia(MultipartFile file , Integer postId, Integer userId) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();
        Media media = mediaRepo.save(Media.builder()
                .name(file.getOriginalFilename())
                .mediaType(file.getContentType()).mediaPath(filePath)
                .userId(userId)
                .postId(postId)
                .build());

        file.transferTo(new File(filePath));

        if(media != null){
            return  "file uploaded successfully: " + filePath;
        }
        return null;
    }



    @Override
    public byte[] downloadMedia(String fileName) throws IOException {
        Optional <Media> media = mediaRepo.findByName(fileName);
        String filepath = media.get().getMediaPath();
        byte [] m = Files.readAllBytes(new File(filepath).toPath());
        return m;
    }


}
