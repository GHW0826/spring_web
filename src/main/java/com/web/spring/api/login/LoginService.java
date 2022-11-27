package com.web.spring.api.login;

import com.web.spring.api.user.UserEntity;
import com.web.spring.api.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    /**
     * @return null이면 로그인 실패
     */
    public UserEntity login(String sid, String password) {
        return userRepository.findBySid(sid)
                .filter(u -> u.getPassword().equals(password))
                .orElse(null);
    }
}
