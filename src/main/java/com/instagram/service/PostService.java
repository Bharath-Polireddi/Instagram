package com.instagram.service;

import com.instagram.entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PostService {

   List <Post> getPosts(Integer id);

   String deletePost(Integer id);

   Post updatePost(Integer id, String caption);

   Post createPost(Post post);

   Integer noOfPosts(Integer id);

}
