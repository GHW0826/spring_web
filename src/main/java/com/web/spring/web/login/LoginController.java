package com.web.spring.web.login;

import com.web.spring.api.login.LoginService;
import com.web.spring.api.session.MemorySessionManager;
import com.web.spring.api.session.SessionConst;
import com.web.spring.api.user.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/web")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final MemorySessionManager memorySessionManager;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginDefaultForm form) {
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute("loginForm") LoginDefaultForm form,
            BindingResult bindingResult,
            @RequestParam(defaultValue = "/web") String redirectURL,
            HttpServletRequest request) {

        if (bindingResult.hasErrors())
            return "login/loginForm";

        Optional<UserEntity> loginUser = loginService.login(form.getSid(), form.getPassword());
        if (loginUser.get() == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        log.info("after check");
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, loginUser.get());
        log.info("before return");
        return "redirect:/web";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null)
            session.invalidate();
        return "redirect:/web";
    }
}
