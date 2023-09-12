package com.instagram.repo;

import com.instagram.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

    @Query("from Comment c where c.postId =:id")
    Comment getComments(@Param("id") Integer postId);
}
