package com.instagram.rest;

import com.instagram.dto.AuthenticationRequest;
import com.instagram.dto.JwtResponse;
import com.instagram.dto.RefreshTokenRequest;
import com.instagram.model.RefreshToken;
import com.instagram.model.User;
import com.instagram.service.JwtService;
import com.instagram.service.RefreshTokenService;
import com.instagram.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
   @Autowired
    UserService userService;

   @Autowired
   private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RefreshTokenService refreshTokenService;



    @Operation(summary = "get the list of users")
    @GetMapping("/admin/list/users")
    //@PreAuthorize("hasAuthority('admin')")
    public List<User> listUsers(){
        return userService.getAllUsers();
    }

    @Operation(summary = "get the user details by userId")
    @GetMapping("/user/{id}")
    @PreAuthorize("hasAuthority('user')")
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }


    @Operation(summary = "create a new user")
    @PostMapping("/new/account")
    public User createUser(@RequestBody User user){
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPwd = bcrypt.encode(user.getPassword());
        user.setPassword(encryptedPwd);
        return  userService.createUser(user);
    }

    @Operation(summary = "update username by taking input userId")
    @PutMapping("/user/{id}/{username}")
    public User updateUserName(@PathVariable("id") Integer id, @PathVariable("username") String name){
        return userService.updateUser(id, name);
    }

    @Operation(summary = "delete the user")
    @DeleteMapping("/admin/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        return userService.deleteUser(id);
    }

    @Operation(summary = "get JWT and UUID by entering username and password")
    @PostMapping("/authenticate")
    public JwtResponse authenticateAndGetToken(@RequestBody AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
        if(authentication.isAuthenticated()){
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(authenticationRequest.getUserName());
            return JwtResponse.builder()
                    .accessToken(jwtService.generateToken(authenticationRequest.getUserName()))
                    .Token(refreshToken.getToken()).build();
        }

        throw new UsernameNotFoundException("invalid user request !!!!");

    }

    @PostMapping("/refreshToken")
    public JwtResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return refreshTokenService.findByToken(refreshTokenRequest.getToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(User -> {
                    String accessToken = jwtService.generateToken(User.getUserName());
                    return JwtResponse.builder()
                            .accessToken(accessToken)
                            .Token(refreshTokenRequest.getToken())
                            .build();
                }).orElseThrow(() -> new RuntimeException("Refresh token is not in database"));

   }



}
