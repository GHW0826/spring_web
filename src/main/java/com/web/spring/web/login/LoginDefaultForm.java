package com.web.spring.web.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDefaultForm {
    @NotEmpty
    private String sid;
    @NotEmpty
    private String password;
}

