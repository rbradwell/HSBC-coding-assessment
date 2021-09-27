package com.hsbc.devassessment.service.impl;

import com.hsbc.devassessment.entity.UserEntity;
import com.hsbc.devassessment.exception.TechnicalException;
import com.hsbc.devassessment.exception.UserNotFoundException;
import com.hsbc.devassessment.model.OnCreate;
import com.hsbc.devassessment.model.OnUpdate;
import com.hsbc.devassessment.model.SearchRequest;
import com.hsbc.devassessment.model.User;
import com.hsbc.devassessment.repo.UserRepository;
import com.hsbc.devassessment.utils.UserEntityToUserConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final UserEntityToUserConverter converter = new UserEntityToUserConverter();

    @Autowired
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Unable to delete user {} " + e.getMessage());
            throw new TechnicalException(e.getMessage());
        }
    }

    @Override
    @Validated(OnCreate.class)
    public User createUser(@Valid User user) {
        try {
            UserEntity userToCreate = new UserEntity();
            userToCreate.setSurname(user.getSurname());
            userToCreate.setFirstname(user.getFirstname());
            userToCreate.setDob(user.getDob());
            userToCreate.setTitle(user.getTitle());
            UserEntity entity = userRepository.save(userToCreate);
            return converter.convert(entity);
        } catch (Exception e) {
            log.error("Unable to create user {} " + e.getMessage());
            throw new TechnicalException(e.getMessage());
        }
    }

    @Override
    public List<User> search(@Valid SearchRequest searchRequest) {
        String firstname = searchRequest.getFirstname();
        String surname = searchRequest.getSurname();
        Long id = searchRequest.getId() == null ? null:
                Long.parseLong(searchRequest.getId());

        UserEntity example = new UserEntity();
        example.setId(id);
        example.setFirstname(firstname);
        example.setSurname(surname);

        ExampleMatcher userMatcher = ExampleMatcher.matchingAny()
                .withIgnoreCase("id", "firstname", "surname")
                .withNullHandler(ExampleMatcher.NullHandler.INCLUDE)
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        List<UserEntity> userEntities = userRepository.findAll(Example.of(example, userMatcher));
        return converter.convertList(userEntities);
    }

    @Override
    public User findById(Long id){
        Optional<UserEntity> entity = userRepository.findById(id);
        if (entity.isEmpty()) {
            throw new UserNotFoundException();
        }
        return converter.convert(entity.get());
    }

    @Override
    @Validated(OnUpdate.class)
    public User updateUser(@Valid User user) {

        Optional<UserEntity> userEntityOptional = userRepository.findById(Long.parseLong(user.getId()));
        if (userEntityOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        UserEntity userEntity = userEntityOptional.get();
        if (user.getTitle() != null) {
            userEntity.setTitle(user.getTitle());
        }
        if (user.getSurname() != null) {
            userEntity.setSurname(user.getSurname());
        }
        if (user.getDob() != null) {
            userEntity.setDob(user.getDob());
        }
        if (user.getFirstname() != null){
            userEntity.setFirstname(user.getFirstname());
        }
        userEntity = userRepository.save(userEntity);
        return converter.convert(userEntity);
    }

}
