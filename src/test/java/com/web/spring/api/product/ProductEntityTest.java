package com.web.spring.api.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductEntityTest {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @Test
    public void registerProduct() throws Exception {
        //given
        // String productName, Brand brand,
        // Integer price, Category category, Integer stockQuantity
        ProductEntity product = new ProductEntity("top1", Brand.NIKE, 10000, Category.SHIRT, 100);

        Long savedId = productService.registerProduct(product);

        assertEquals(Optional.empty(), productRepository.findById(5L));
        assertEquals(product, productRepository.findById(savedId).get());
    }

    @Test
    public void findAllJPA() throws Exception {
        ProductEntity product1 = new ProductEntity("top1", Brand.NIKE, 10000, Category.SHIRT, 100);
        ProductEntity product2 = new ProductEntity("top2", Brand.ADIDAS, 20000, Category.SHIRT, 200);
        ProductEntity product3 = new ProductEntity("top3", Brand.NIKE, 30000, Category.SHIRT, 300);

        Long savedId1 = productService.registerProduct(product1);
        Long savedId2 = productService.registerProduct(product2);
        Long savedId3 = productService.registerProduct(product3);

        List<ProductEntity> result = productService.findAll();
        assertThat(result.get(0).getProductName()).isEqualTo("top1");
        assertThat(result.get(1).getProductName()).isEqualTo("top2");
        assertThat(result.get(2).getProductName()).isEqualTo("top3");
        assertThat(result.size()).isEqualTo(3);
    }
}