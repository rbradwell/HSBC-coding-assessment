package com.hsbc.devassessment.utils;

import com.hsbc.devassessment.entity.UserEntity;
import com.hsbc.devassessment.model.User;

import java.util.List;

public class UserEntityToUserConverter extends GenericInstanceConverter<User, UserEntity> {

    public List<User> convertList(List<UserEntity> fromList) {
        return this.convertList(fromList, UserEntity.class.getCanonicalName(), User.class.getCanonicalName()) ;
    }

    public User convert(UserEntity from) {
        return this.convert(from, UserEntity.class.getCanonicalName(), User.class.getCanonicalName()) ;
    }

}