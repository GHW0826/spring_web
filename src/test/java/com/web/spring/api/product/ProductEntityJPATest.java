package com.web.spring.api.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class ProductEntityJPATest {

    @Autowired
    ProductJpaService productJPAService;
    @Autowired
    ProductJpaRepository productJPARepository;

    @Test
    public void registerProductJPA() throws Exception {
        //given
        // String productName, Brand brand,
        // Integer price, Category category, Integer stockQuantity
        ProductEntity product = new ProductEntity("top1", Brand.NIKE, 10000, Category.SHIRT, 100);

        Long savedId = productJPAService.registerProduct(product);

        assertEquals(Optional.empty(), productJPARepository.findById(5L));
        assertEquals(product, productJPARepository.findById(savedId).get());
    }

    @Test
    public void findAllJPA() throws Exception {
        ProductEntity product1 = new ProductEntity("top1", Brand.NIKE, 10000, Category.SHIRT, 100);
        ProductEntity product2 = new ProductEntity("top2", Brand.ADIDAS, 20000, Category.SHIRT, 200);
        ProductEntity product3 = new ProductEntity("top3", Brand.NIKE, 30000, Category.SHIRT, 300);

        Long savedId1 = productJPAService.registerProduct(product1);
        Long savedId2 = productJPAService.registerProduct(product2);
        Long savedId3 = productJPAService.registerProduct(product3);

        List<ProductEntity> result = productJPAService.findAll();
        assertThat(result.get(0).getProductName()).isEqualTo("top1");
        assertThat(result.get(1).getProductName()).isEqualTo("top2");
        assertThat(result.get(2).getProductName()).isEqualTo("top3");
        assertThat(result.size()).isEqualTo(3);
    }
}
