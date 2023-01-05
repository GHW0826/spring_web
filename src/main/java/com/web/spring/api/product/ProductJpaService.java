package com.web.spring.api.product;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductJpaService {
    private final ProductJpaRepository productJPARepository;

    @Transactional
    public Long registerProduct(ProductEntity product) {
        productJPARepository.save(product);
        return product.getId();
    }

    @Transactional
    public List<ProductEntity> findAll() {
        return productJPARepository.findAll();
    }
}
