package com.instagram.repo;

import com.instagram.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    @Query("from Post p where p.postUser.userId =:id")
    List<Post> getAllPosts(@Param("id") Integer id);

    @Query("select count(*) from Post p where  p.postUser.userId =:id")
    Integer getPostsCount(@Param("id") Integer userId);

}








