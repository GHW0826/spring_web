package com.web.spring.api.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/product/{id}")
    public ProductEntity.findByIdResponse findById(@PathVariable("id") Long id) {
        ProductEntity product = productService.findById(id).get();
        /*
            private Long id;
            private String productName;
            private Brand brand;
            private Integer price;
            private Category category;
            private Integer stockQuantity;
         */
        return new ProductEntity.findByIdResponse(
                product.getId(), product.getProductName(), product.getBrand(),
                product.getPrice(), product.getCategory(), product.getStockQuantity());
    }
}
