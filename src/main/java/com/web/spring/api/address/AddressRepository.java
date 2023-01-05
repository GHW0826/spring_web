package com.web.spring.api.address;

import com.web.spring.api.product.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AddressRepository {

    private final EntityManager em;

    public void save(AddressEntity address) {
        em.persist(address);
    }

    public Optional<AddressEntity> findById(Long address_id) {
        AddressEntity address = em.find(AddressEntity.class, address_id);
        return Optional.ofNullable(address);
    }
}
