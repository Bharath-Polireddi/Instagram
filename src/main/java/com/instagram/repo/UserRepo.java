package com.instagram.repo;

import com.instagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUserName(String username);

}
