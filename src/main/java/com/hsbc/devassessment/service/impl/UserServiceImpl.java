package com.hsbc.devassessment.service.impl;

import com.hsbc.devassessment.entity.UserEntity;
import com.hsbc.devassessment.exception.UserNotFoundException;
import com.hsbc.devassessment.model.User;
import com.hsbc.devassessment.repo.UserRepository;
import com.hsbc.devassessment.utils.DtoToEntityConverter;
import com.hsbc.devassessment.utils.EntityToDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User createUser(User user) {
        //TODO - validate user using bean validation
        UserEntity entity = userRepository.save(DtoToEntityConverter.convertFrom(user));
        return EntityToDtoConverter.convertFrom(entity);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = (List<UserEntity>) userRepository.findAll();
        if (userEntities.isEmpty()) {
            throw new UserNotFoundException();
        }
        return EntityToDtoConverter.convertList(userEntities);
    }

    @Override
    public List<User> findByFirstname(String firstname) {
        List<UserEntity> userEntities = userRepository.findByFirstname(firstname);
        if (userEntities.isEmpty()) {
            throw new UserNotFoundException();
        }
        return EntityToDtoConverter.convertList(userEntities);
    }

    @Override
    public List<User> findBySurname(String lastname) {
        List<UserEntity> userEntities = userRepository.findBySurname(lastname);
        return EntityToDtoConverter.convertList(userEntities);
    }

    @Override
    public User findById(Long id){
        Optional<UserEntity> entity = userRepository.findById(id);
        if (entity.isEmpty()) {
            throw new UserNotFoundException();
        }
        return entity.map(EntityToDtoConverter::convertFrom).get();
    }

}
