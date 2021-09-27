package com.hsbc.devassessment.service.impl;

import com.hsbc.devassessment.model.SearchRequest;
import com.hsbc.devassessment.model.User;

import java.util.List;

public interface UserService {
    void deleteUser(Long id);
    User createUser(User user);
    List<User> search(SearchRequest searchRequest);
    User findById(Long id);
    User updateUser(User user);
}
