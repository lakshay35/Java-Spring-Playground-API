package com.example.springbootexample.service;

import com.example.springbootexample.entity.User;
import com.example.springbootexample.model.PasswordChange;
import com.example.springbootexample.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.springbootexample.model.Credentials;

import com.example.springbootexample.repository.UserRepository;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Response<User> login(Credentials credentials) {
       Response<User> result = new Response<User>();

        try {
            User temp = this.repository.findByEmailAndPassword(credentials.getUsername(), credentials.getPassword());
            result.setResponse(temp);
            result.setStatusCode(HttpStatus.OK);
            if(temp != null) {
                result.setMessage("Successfully authenticated");
            } else {
                result.setMessage("Incorrect username/password");
            }

        } catch(Exception e) {
            result.setResponse(null);
            result.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            result.setMessage("Internal server error occurred when validating login credentials.");
        }

        return result;
    }

    public Response<User> signUp(User user) {

        System.out.print("Trying to sign up user: " + user.toString());
        Response<User> result = new Response<User>();

        try {
            User u = new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());

            if(this.repository.existsByEmail(user.getEmail())) {
                result.setMessage("Username already exists");
                result.setStatusCode(HttpStatus.BAD_REQUEST);
                result.setResponse(null);
            } else {
                result.setMessage("Successfully signed up user");
                result.setResponse(u);
                result.setStatusCode(HttpStatus.CREATED);
                this.repository.save(u);
            }

        } catch (Exception e) {
            result.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            result.setResponse(null);
            result.setMessage("Internal server error occurred when signing up new user");
        }

        return result;
    }

    public Response<User> resetPassword(String username) {
        Response<User> result = new Response<User>();

        try {
            if (this.repository.existsByEmail(username)) {
                User u = this.repository.findByEmail(username);
                u.setPassword(UUID.randomUUID().toString());
                result.setResponse(this.repository.save(u));
                result.setStatusCode(HttpStatus.OK);
                result.setMessage("Password successfully reset");
            } else {
               result.setMessage("Could not reset password for email " + username);
               result.setStatusCode(HttpStatus.BAD_REQUEST);
               result.setResponse(null);
            }
        } catch(Exception e) {
            result.setResponse(null);
            result.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            result.setMessage("Internal server error occurred when resetting password for email " + username);
        }

        return result;
    }

    public Response<User> changePassword(PasswordChange request) {
        Response<User> result = new Response<User>();

        try {

            if(this.repository.existsByEmailAndPassword(request.getEmail(), request.getOldPassword())) {
                User u = this.repository.findByEmail(request.getEmail());
                u.setPassword(request.getNewPassword());

                result.setMessage("Password successfully changed.");
                result.setStatusCode(HttpStatus.OK);
                result.setResponse(this.repository.save(u));


            } else {
                result.setStatusCode(HttpStatus.NOT_FOUND);
                result.setMessage("User with email " + request.getEmail() + " not found.");
                result.setResponse(null);
            }
        } catch (Exception e) {
            result.setResponse(null);
            result.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            result.setMessage("Internal server error occurred when changing password for email " + request.getEmail());
        }

        return result;
    }

    public User testSave(User user) {
        return this.repository.save(user);
    }

}
