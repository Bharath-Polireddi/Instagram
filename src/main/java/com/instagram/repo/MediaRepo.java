package com.instagram.repo;

import com.instagram.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MediaRepo extends JpaRepository<Media, Integer> {

    @Query("select count(*) from Media m where m.userId =:userId and m.postId =:postId ")
    Integer getImagesCount(@Param("userId") Integer userId , @Param("postId") Integer postId);

    Optional<Media> findByName(String fileName);

}
