package com.instagram.service;

import com.instagram.entities.Post;
import com.instagram.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PostServiceImp implements PostService {
    @Autowired
    PostRepo postRepo;

    public  List<Post> getPosts(Integer id){
        return postRepo.getAllPosts(id);
    }

    public String deletePost(Integer id){
        var postId = postRepo.findById(id);
        if (postId.isPresent()){
            postRepo.deleteById(id);
            return "post successfully deleted";
        }else{
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "post did not exist");
        }
    }

    public Post updatePost(Integer id, String caption){
        var postId = postRepo.findById(id);
        if(postId.isPresent()){
            Post post = postId.get();
            post.setCaption(caption);
            postRepo.save(post);
            return post;
        }else{
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "post did not exist to update the data");
        }
    }


    public Post createPost(Post newPost){
        postRepo.save(newPost);
        return newPost;
    }

    public  Integer noOfPosts(Integer id){
        return postRepo.getPostsCount(id);
    }


}


