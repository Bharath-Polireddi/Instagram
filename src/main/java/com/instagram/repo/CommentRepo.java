package com.instagram.repo;

import com.instagram.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

    @Query("from Comment c where c.postId =:id")
    List<Comment> getComments(@Param("id") Integer postId);

    @Query(value = "select count(*) from comments c where c.post_id = post_Id", nativeQuery = true)
    Integer getCommentsCount(@Param("id") Integer postId);
}
