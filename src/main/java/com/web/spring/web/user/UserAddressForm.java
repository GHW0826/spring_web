package com.web.spring.web.user;

import lombok.Data;

@Data
public class UserAddressForm {
    String postCode;
    String roadAddress;
    String jibunAddress;
    String detailAddress;
    String extraAddress;
}
