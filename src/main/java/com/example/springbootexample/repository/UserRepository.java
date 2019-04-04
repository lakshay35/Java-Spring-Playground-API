package com.example.springbootexample.repository;

import com.example.springbootexample.entity.User;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmailAndPassword(String username, String password);

    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);

    User findByEmail(String username);
}