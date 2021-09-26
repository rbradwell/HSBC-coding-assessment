package com.hsbc.devassessment.model;

import lombok.Getter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
public class User {

    private String id;
    private String title;
    private String firstname;
    private String surname;
    private String dob;
    private String created;

    public User(String id, String title, String firstname, String surname, Date dob, Timestamp created) {
        this.id = id;
        this.title = title;
        this.firstname = firstname;
        this.surname = surname;
        if (dob != null) {
            this.dob = dob.toString(); // TODO - format correctly
        }
        if (created != null) {
            this.created = created.toString(); // TODO - format correctly
        }
    }

    public void setId(String id) {
        this.id = id;
    }

}
