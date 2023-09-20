package com.instagram.service;

import com.instagram.entities.User;
import com.instagram.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepo usersRepo;

    @Override
    public List<User> getAllUsers() {
        return usersRepo.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        Optional<User> user = usersRepo.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user id not found");
        }

    }


    @Override
    public User createUser(User user) {

        if (usersRepo.findByUserName(user.getUserName()) != null) {
            throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "user already exists with username");
        } else {
            User savedUser = usersRepo.save(user);
            return user;
        }
    }

    @Override
    public User updateUser(Integer id, String username) {
        var userId = usersRepo.findById(id);
        if (userId.isPresent()) {
            User user = userId.get();
            user.setUserName(username);
            usersRepo.save(user);
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user did not exist");
        }
    }


    @Override
    public String deleteUser(Integer id) {
        var userId = usersRepo.findById(id);
        if (userId.isPresent()) {
            usersRepo.deleteById(id);
            return "user successfully deleted";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user did not exist");
        }
    }

}
