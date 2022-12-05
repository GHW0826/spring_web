package com.web.spring.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /** sign up */
    @Transactional
    public Long join(UserEntity user) {
        userRepository.save(user);
        return user.getUid();
    }
    /*
    private void validateDuplicateMember(UserDao user) {
        List<UserDao> findMembers = userRepository.findBySid(user.getSid());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<UserDao> findMembers() {
        return userRepository.findAll();
    }

    public UserDao findOne(Long userId) {
        return userRepository.findOneByUid(userId);
    }
    */
}
