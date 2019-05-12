package com.example.springbootexample.controller;

import com.example.springbootexample.entity.User;
import com.example.springbootexample.model.Credentials;
import com.example.springbootexample.model.PasswordChange;
import com.example.springbootexample.model.Response;
import com.example.springbootexample.service.UserService;
import com.example.springbootexample.task.SchedulesTasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "User Controller works!";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Response<User> login(@RequestBody Credentials credentials) {
        return this.service.login(credentials);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public Response<User> signup(@RequestBody User user) {
        return this.service.signUp(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/forgot-password")
    public Response<User> resetPassword(@RequestParam String username) {
        return this.service.resetPassword(username);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/change-password")
    public Response<User> changePassword(@RequestBody PasswordChange request) {
        return this.service.changePassword(request);
    }
}