package com.web.spring.api.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    public void save(UserEntity user) {
        em.persist(user);
    }
    public UserEntity findOneByUid(Long id) {
        return em.find(UserEntity.class, id);
    }

    public List<UserEntity> findBySid(String sid) {
        return em.createQuery("select u from User u where u.sid = :sid", UserEntity.class)
                .setParameter("sid", sid)
                .getResultList();
    }

    public List<UserEntity> findAll() {
        return em.createQuery("select m from Member m", UserEntity.class)
                .getResultList();
    }
}
