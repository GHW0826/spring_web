package com.web.spring.api.product;

import com.web.spring.api.user.UserEntity;
import com.web.spring.web.product.ProductUpdateForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/product/{id}")
    public ProductEntity.findByIdResponse findById(@PathVariable("id") Long id) {
        Optional<ProductEntity> productEntity = productService.findById(id);
        ProductEntity product = productEntity.get();
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

    @PostMapping("/product/register")
    public ProductEntity.RegisterProductResponse registerProduct(@RequestBody @Valid final ProductEntity.RegisterProductRequest body) {
        Long productId = productService.registerProduct(new ProductEntity(body));
        return new ProductEntity.RegisterProductResponse(productId, body);
    }

    @PutMapping("/product/{productId}")
    public ProductEntity.RegisterProductResponse updateProduct(@PathVariable("productId") Long productId, @RequestBody @Valid final ProductEntity.RegisterProductRequest body) {
        productService.updateProductApi(productId, body);
        return new ProductEntity.RegisterProductResponse(productId, body);
    }

    @DeleteMapping("/product/{productId}")
    public ProductEntity.deleteProductResponse deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
        return  new ProductEntity.deleteProductResponse(productId);
    }
}
