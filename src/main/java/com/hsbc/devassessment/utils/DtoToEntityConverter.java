package com.hsbc.devassessment.utils;

import com.hsbc.devassessment.entity.UserEntity;
import com.hsbc.devassessment.model.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtoToEntityConverter {

    public static List<UserEntity> convertList(List<User> list) {
        List<UserEntity> result = new ArrayList<>();
        for (User entity : list) {
            result.add(convertFrom(entity));
        }
        return result;
    }

    public static UserEntity convertFrom(User entity) {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreated(new Timestamp(new Date().getTime()));
        userEntity.setDob(userEntity.getDob());
        userEntity.setFirstname(userEntity.getFirstname());
        userEntity.setSurname(userEntity.getSurname());
        userEntity.setTitle(userEntity.getTitle());
        return userEntity;
    }

}
