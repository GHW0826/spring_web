package com.web.spring.api.address;


import com.web.spring.api.user.UserEntity;
import com.web.spring.web.user.UserAddressForm;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "tblAddress")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressEntity {
    @Id @GeneratedValue
    @Column(name = "address_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "uid")
    private UserEntity user;

    String postCode;
    String roadAddress;
    String jibunAddress;
    String detailAddress;
    String extraAddress;

    public void setUser(UserEntity user) {
        this.user = user;
        user.getAddress().add(this);
    }

    public AddressEntity(UserEntity user, UserAddressForm addressForm) {
        setUser(user);
        this.postCode = addressForm.getPostCode();
        this.roadAddress = addressForm.getRoadAddress();
        this.jibunAddress = addressForm.getJibunAddress();
        this.detailAddress = addressForm.getDetailAddress();
        this.extraAddress = addressForm.getExtraAddress();
    }
}
