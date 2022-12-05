package com.web.spring.web;

import com.web.spring.api.session.SessionConst;
import com.web.spring.api.user.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequestMapping("/web")
@RequiredArgsConstructor
public class HomeController {
    @GetMapping
    public String home
            (@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserEntity loginUser,
            Model model) {
        if (loginUser == null)
            return "home";
        log.info("go to lobby");
        model.addAttribute("user", loginUser);
        return "lobby";
    }
}
