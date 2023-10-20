package com.instagram.repo;

import com.instagram.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeRepo extends JpaRepository<Like, Integer> {

    @Query("select count(*) from Like l where l.postId=:id")
     Integer noOfLikes(@Param("id") Integer postId);
}
