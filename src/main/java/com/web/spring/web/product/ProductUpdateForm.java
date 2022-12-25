package com.web.spring.web.product;

import com.web.spring.api.product.Brand;
import com.web.spring.api.product.Category;
import com.web.spring.api.product.ProductEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductUpdateForm {
    private Long id;
    private String productName;
    private Brand brand;
    private Integer price;
    private Category category;
    private int stockQuantity;

    public ProductUpdateForm(ProductEntity productEntity) {
        this.id = productEntity.getId();
        this.productName = productEntity.getProductName();
        this.brand = productEntity.getBrand();
        this.price = productEntity.getPrice();
        this.category = productEntity.getCategory();
        this.stockQuantity = productEntity.getStockQuantity();
    }
}

