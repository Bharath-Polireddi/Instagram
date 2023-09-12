package com.instagram.repo;

import com.instagram.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageRepo extends JpaRepository<Image, Integer> {

    @Query("select count(*) from Image i where i.userId =:userId and i.postId =:postId ")
    Integer getImagesCount(@Param("userId") Integer userId , @Param("postId") Integer postId);

}
