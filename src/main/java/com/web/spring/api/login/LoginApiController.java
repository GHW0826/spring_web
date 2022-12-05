package com.web.spring.api.login;

import com.web.spring.api.exception.UserException;
import com.web.spring.api.session.SessionConst;
import com.web.spring.api.user.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginApiController {
    private final LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<UserEntity.RegisterUserResponse> regist
            (@RequestBody @Valid final UserEntity.RegisterUserRequest body,
             HttpServletRequest request) {

        Optional<UserEntity> loginUser = loginService.login(body.getSid(), body.getPassword());
        log.info(loginUser.toString());
        if (loginUser == null)
            throw new UserException("사용자 오류");

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, loginUser);
        return ResponseEntity.ok(new UserEntity.RegisterUserResponse(loginUser.get().getSid()));
    }
}


