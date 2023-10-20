package com.instagram.UserService;


import com.instagram.model.User;
import com.instagram.repo.UserRepo;
import com.instagram.service.UserServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {


    private UserServiceImp userServiceImp;


    @Mock
    private UserRepo userRepoMock;


    private List<User> users = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userServiceImp = new UserServiceImp(userRepoMock);

    }

    @Test
    void testAllUsers() {
        users.add(new User(1, "walter@gmail.com", "w_white", "white@21", "admin"));
        users.add(new User(2, "jessie@gmail.com", "j_pinkman", "pink@21", "user"));
        when(userRepoMock.findAll()).thenReturn(users);
        assertEquals(2, userServiceImp.getAllUsers().size(), "testing list of users");
    }

    @Test
    void testUserById() {
        //Arrange
        Integer userId = 1;
        User expectedUser = new User(userId, "walter@gmail.com", "w_white", "white@21", "admin");


        //Mock the behaviour of userRepository.findById()
        when(userRepoMock.findById(userId)).thenReturn(Optional.of(expectedUser));


        //Act
        User actualUser = userServiceImp.getUserById(userId);

        //Assert
        assertNotNull(actualUser);
        assertEquals(expectedUser, actualUser,  " get user by userId");

       //verify that userRepository.findById() was called with the correct userId
        verify(userRepoMock).findById(userId);
    }


    @Test
    void testCreateUser(){

        User newUser = new User(1, "jessie@gmail.com", "j_pinkman", "pink@21", "user");
        when(userRepoMock.save(newUser)).thenReturn(newUser);

        User createUser = userServiceImp.createUser(newUser);

        assertNotNull(createUser);
        assertEquals(newUser, createUser);
        verify(userRepoMock).save(newUser);


    }





}
