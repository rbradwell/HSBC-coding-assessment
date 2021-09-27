package com.hsbc.devassessment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hsbc.devassessment.entity.UserEntity;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
public class User {

    @Null(groups = OnCreate.class)
    @NotNull(groups = OnUpdate.class)
    private String id;

    @Size(max=20)
    @NotNull(groups = OnCreate.class)
    private String title;

    @Size(max=250)
    @NotNull(groups = OnCreate.class)
    private String firstname;

    @Size(max=250)
    @NotNull(groups = OnCreate.class)
    private String surname;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;

    public User(UserEntity userEntity) {
        this.id = String.valueOf(userEntity.getId());
        this.title = userEntity.getTitle();
        this.firstname = userEntity.getFirstname();
        this.surname = userEntity.getSurname();
        this.dob = userEntity.getDob();
    }


}
