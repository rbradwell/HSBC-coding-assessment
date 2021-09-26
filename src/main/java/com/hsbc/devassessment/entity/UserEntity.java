package com.hsbc.devassessment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="User")
public class UserEntity implements Serializable {

    @Id
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="firstname", nullable = false)
    private String firstname;

    @Column(name="surname", nullable = false)
    private String surname;

    @Column(name="dob", nullable = false)
    private Date dob;

    @Column(name="created")
    private Timestamp created;

    // TODO - implement equals/ hashcode using lombok

}
