package com.hsbc.devassessment.service.impl;

import com.hsbc.devassessment.model.User;

import java.util.List;

public interface UserService {
    void deleteUser(Long id);
    User createUser(User user);
    List<User> findAll();
    List<User> findByFirstname(String firstname);
    List<User> findBySurname(String lastname);
    User findById(Long id);
}
