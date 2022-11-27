package com.web.spring.api.user;


import com.web.spring.web.User.UserDefaultForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="User")
@Table(name="tblUser")
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

    public UserEntity() {}
    public UserEntity(UserDefaultForm userDefaultForm) {
        sid = userDefaultForm.getSid();
        password = userDefaultForm.getPassword();
        email = userDefaultForm.getEmail();
    }
}