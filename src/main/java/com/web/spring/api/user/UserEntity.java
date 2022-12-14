package com.web.spring.api.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.spring.api.address.AddressEntity;
import com.web.spring.web.user.UserDefaultForm;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity(name="User")
@Table(name="tblUser")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long uid;

    @Column(name = "sid")
    private String sid;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<AddressEntity> address = new ArrayList<>();

    public UserEntity(UserDefaultForm userDefaultForm) {
        sid = userDefaultForm.getSid();
        password = userDefaultForm.getPassword();
        email = userDefaultForm.getEmail();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterUserRequest {
        @NotEmpty
        private String sid;
        @NotEmpty
        private String password;
    }

    @Data
    @AllArgsConstructor
    public static class RegisterUserResponse {
        @NotEmpty
        private String sid;
    }
}