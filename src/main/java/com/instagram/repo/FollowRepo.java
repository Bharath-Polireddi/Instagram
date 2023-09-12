package com.instagram.repo;

import com.instagram.entities.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepo extends JpaRepository<Follow, Integer> {
}
