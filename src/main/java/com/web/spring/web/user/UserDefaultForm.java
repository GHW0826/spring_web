package com.web.spring.web.user;

import lombok.Data;


@Data
public class UserDefaultForm {
    private String sid;
    private String password;
    private String email;
    private UserAddressForm address;
}


