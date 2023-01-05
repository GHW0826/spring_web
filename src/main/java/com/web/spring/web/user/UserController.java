package com.web.spring.web.user;

import com.web.spring.api.address.AddressEntity;
import com.web.spring.api.address.AddressService;
import com.web.spring.api.user.UserEntity;
import com.web.spring.api.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/web/users")
public class UserController {
    private final UserService userService;

    private final AddressService addressService;

    @GetMapping("/join")
    public String addUserForm(@ModelAttribute("user") UserDefaultForm user) {
        return "users/joinUserForm";
    }

    @PostMapping("/join")
    public String save(@Valid @ModelAttribute("user") UserDefaultForm user, BindingResult result) {
        if (result.hasErrors())
            return "users/joinUserForm";

        log.info(user.toString());
        UserEntity nweUser = new UserEntity(user);
        userService.join(nweUser);
        addressService.registerAddress(new AddressEntity(nweUser, user.getAddress()));
        return "redirect:/web";
    }
}
