package com.web.spring.web.mypage;


import com.web.spring.api.session.SessionConst;
import com.web.spring.api.user.UserEntity;
import com.web.spring.web.argumentresolver.LoginAuth;
import com.web.spring.web.user.UserDefaultForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/my-page")
public class MyPageWebController {

    @GetMapping
    public String mypage(@LoginAuth UserEntity loginUser, Model model) {
        model.addAttribute("user", loginUser);
        return "users/my-page/my-page";
    }
}
