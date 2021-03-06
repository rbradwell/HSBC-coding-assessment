package com.hsbc.devassessment.repo;

import com.hsbc.devassessment.model.SearchRequest;
import com.hsbc.devassessment.model.User;
import com.hsbc.devassessment.service.impl.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTests {

    // TODO - convert these into mockmvc

    private static final Logger log = LoggerFactory.getLogger(UserServiceImplTests.class);

    @Autowired
    private UserService userService;

    @Test
    public void test_shouldReturnUserByFirstName() {
        SearchRequest request = SearchRequest.builder().firstname("Richard").build();
        List<User> users = userService.search(request);
        Assert.assertFalse(users.isEmpty());
        User user = users.get(0);
        Assert.assertEquals("Bradwell", user.getSurname());
    }

    @Test
    public void test_shouldReturnUserBySurname() {
        SearchRequest request = SearchRequest.builder().firstname("Bradwell").build();
        List<User> users = userService.search(request);
        Assert.assertFalse(users.isEmpty());
        Assert.assertEquals(2, users.size());
    }

    @Test
    public void test_findById() {
        User user = userService.findById(2L);
    }

}
