package com.hsbc.devassessment.controller;

import com.hsbc.devassessment.model.SearchRequest;
import com.hsbc.devassessment.model.User;
import com.hsbc.devassessment.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/1.0.0/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    ResponseEntity<User> createNewUser(@RequestBody User newUser) {
        return new ResponseEntity<>(userService.createUser(newUser), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<User>> getUsersByFirstname(@RequestBody SearchRequest searchRequest) {
        return new ResponseEntity<>(userService.search(searchRequest), HttpStatus.OK);
    }

}
