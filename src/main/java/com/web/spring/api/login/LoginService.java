package com.web.spring.api.login;

import com.web.spring.api.user.UserEntity;
import com.web.spring.api.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    /**
     * @return null이면 로그인 실패
     */
    public Optional<UserEntity> login(String sid, String password) {
        return Optional.ofNullable(userRepository.findBySid(sid)
                .filter(u -> u.getPassword().equals(password))
                .orElse(null)).stream().findAny();
    }
}
