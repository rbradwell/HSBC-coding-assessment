package com.hsbc.devassessment.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name="User")
public class UserEntity implements Serializable {

    @Id
    private Long id;

    @Column(name="title", length=20, nullable = false)
    private String title;

    @Column(name="firstname", length=250, nullable = false)
    private String firstname;

    @Column(name="surname", length=250, nullable = false)
    private String surname;

    @Column(name="dob", nullable = false)
    private Date dob;

    @Column(name="created")
    private Timestamp created;

    @PrePersist
    private void onCreate() {
        this.created = new Timestamp(System.currentTimeMillis());
    }

}
