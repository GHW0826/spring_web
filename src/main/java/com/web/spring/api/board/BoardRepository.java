package com.web.spring.api.board;

import com.web.spring.api.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;

    public Optional<BoardEntity> findById(Long id) {
        return Optional.ofNullable(em.createQuery("select b from Board b where b.id = :id", BoardEntity.class)
                .setParameter("id", id)
                .getSingleResult());
    }

}
