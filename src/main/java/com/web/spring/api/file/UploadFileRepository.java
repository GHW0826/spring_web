package com.web.spring.api.file;

import com.web.spring.api.board.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UploadFileRepository {
    private final EntityManager em;

    public Optional<UploadFileEntity> findById(Long id) {
        return Optional.ofNullable(em.createQuery("select uf from UploadFile uf where uf.id = :id", UploadFileEntity.class)
                .setParameter("id", id)
                .getSingleResult());
    }
}
