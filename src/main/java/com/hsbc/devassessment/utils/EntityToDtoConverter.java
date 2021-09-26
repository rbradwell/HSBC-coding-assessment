package com.hsbc.devassessment.utils;

import com.hsbc.devassessment.entity.UserEntity;
import com.hsbc.devassessment.model.User;

import java.util.ArrayList;
import java.util.List;

public class EntityToDtoConverter {

    public static List<User> convertList(List<UserEntity> list) {
        List<User> result = new ArrayList<>();
        for (UserEntity entity : list) {
            result.add(convertFrom(entity));
        }
        return result;
    }

    public static User convertFrom(UserEntity entity) {
        return new User(Long.toString(entity.getId()),
                entity.getTitle(),
                entity.getFirstname(),
                entity.getSurname(),
                entity.getDob(),
                entity.getCreated());
    }

}
