package com.web.spring.web.user;

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
@RequestMapping("/users")
public class UserWebController {
    private final UserService userService;

    @GetMapping("/join")
    public String addForm(@ModelAttribute("user") UserDefaultForm member) {
        return "users/joinUserForm";
    }

    @PostMapping("/join")
    public String save(@Valid @ModelAttribute("user") UserDefaultForm user, BindingResult result) {
        if (result.hasErrors())
            return "users/joinUserForm";

        log.info(user.toString());
        userService.join(new UserEntity(user));
        return "redirect:/";
    }
}
