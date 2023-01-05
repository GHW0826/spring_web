package com.web.spring.api.product;

import com.web.spring.api.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    @Transactional
    public void updateProductApi(Long productId, ProductEntity.RegisterProductRequest requset) {
        productRepository.updateProductByRequestApi(productId, requset);
    }

    @Transactional
    public Long registerProduct(ProductEntity product) {
        productRepository.save(product);
        return product.getId();
    }

    @Transactional
    public Optional<ProductEntity> findById(Long productId) {
        return productRepository.findById(productId);
    }

    @Transactional
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public void updateProduct(Long productId, String productName, Brand brand, Integer price, Category category, Integer stockQuantity) {
        productRepository.updateProduct(productId, productName, brand, price, category, stockQuantity);
    }

    @Transactional
    public void deleteProduct(Long productId) {
        productRepository.deleteProduct(productId);
    }
}
