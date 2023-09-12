package com.instagram.rest;

import com.instagram.entities.User;
import com.instagram.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
   @Autowired
    UserService userService;
    @Operation(summary = "get the list of users")
    @GetMapping("list/users")
    public List<User> listUsers(){
        return userService.getAllUsers();
    }

    @Operation(summary = "get the user details by userId")
    @GetMapping("user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }


    @Operation(summary = "create a new user")
    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return  userService.createUser(user);
    }

    @Operation(summary = "update username by taking input userId")
    @PutMapping("user/{id}/{uName}")
    public User updateUserName(@PathVariable("id") Integer id, @PathVariable("uName") String name){
        return userService.updateUser(id, name);
    }

    @Operation(summary = "delete the user")
    @DeleteMapping("User/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        return userService.deleteUser(id);
    }



}
