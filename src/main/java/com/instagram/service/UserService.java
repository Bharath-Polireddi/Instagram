package com.instagram.service;

import com.instagram.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer userId);

    User createUser(User user);

    User updateUser(Integer id, String username);

    String deleteUser(Integer id);

}
