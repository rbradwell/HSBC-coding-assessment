package com.hsbc.devassessment.controller;

import com.hsbc.devassessment.model.User;
import com.hsbc.devassessment.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/hsbc")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/1.0.0/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> all() {
        return userService.findAll();
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @PostMapping("/1.0.0/user/")
    User createNewUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @DeleteMapping("/1.0.0/user/{id}")
    void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @GetMapping(value="/1.0.0/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @GetMapping(value = "/1.0.0/user", produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> getUsersByFirstname(@RequestParam(value="firstname") String firstname) {
        return userService.findByFirstname(firstname);
    }
//
//    @ResponseStatus(value= HttpStatus.OK)
//    @GetMapping(value = "/1.0.0/user", produces = MediaType.APPLICATION_JSON_VALUE)
//    List<User> getUsersBySurname(@RequestParam(value="surname") String surname) {
//        return userService.findBySurname(surname);
//    }

}
