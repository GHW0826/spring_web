package com.web.spring.api.User;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="tblUser")
@Getter @Setter
public class UserEntity {
    @Id @GeneratedValue
    @Column(name = "uid")
    private Long id;

    @Column(name = "sid")
    private String sid;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
}