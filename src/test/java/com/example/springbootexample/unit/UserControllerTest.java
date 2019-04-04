package com.example.springbootexample.unit;

import com.example.springbootexample.controller.UserController;
import com.example.springbootexample.entity.User;
import com.example.springbootexample.model.Response;
import com.example.springbootexample.repository.UserRepository;
import com.example.springbootexample.service.UserService;
import com.example.springbootexample.servicetest.UserServiceTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

    @Test
    public void testSignUp() {
        User testUser = new User("Deepshikha", "Sharma", "deepshikhasharma20@gmail.com", "password");

        Response<User> expectedResponse = new Response<User>();

        expectedResponse.setResponse(testUser);
        expectedResponse.setStatusCode(HttpStatus.CREATED);
        expectedResponse.setMessage("Successfully signed up user");

        Mockito.when(this.repository.save(testUser)).thenReturn(testUser);

        Assert.assertEquals(testUser, this.service.testSave(testUser));
    }

}
