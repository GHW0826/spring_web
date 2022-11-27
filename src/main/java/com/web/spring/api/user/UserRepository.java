package com.web.spring.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

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

    public Optional<UserEntity> findBySid(String sid) {
        return Optional.ofNullable(em.createQuery("select u from User u where u.sid = :sid", UserEntity.class)
                .setParameter("sid", sid)
                .getSingleResult());
    }

    public List<UserEntity> findAll() {
        return em.createQuery("select u from User u", UserEntity.class)
                .getResultList();
    }
}
