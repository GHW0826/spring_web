package com.web.spring.api.product;

import com.web.spring.api.product.exception.ProductException;
import com.web.spring.web.product.ProductDefaultForm;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name="Product")
@Table(name="tbl_product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name")
    private String productName;

    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Column(name = "price")
    private Integer price;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    public ProductEntity(String productName, Brand brand, Integer price, Category category, Integer stockQuantity) {
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }

    public ProductEntity (ProductDefaultForm defaultForm) {
        this.productName = defaultForm.getProductName();
        this.brand = defaultForm.getBrand();
        this.price = defaultForm.getPrice();
        this.category = defaultForm.getCategory();
        this.stockQuantity = defaultForm.getStockQuantity();
    }

    public ProductEntity (RegisterProductRequest request) {
        this.productName = request.getProductName();
        this.brand = request.getBrand();
        this.price = request.getPrice();
        this.category = request.getCategory();
        this.stockQuantity = request.getStockQuantity();
    }

    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new ProductException("need more stock");
        }
        this.stockQuantity = restStock;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterProductRequest {
        private String productName;
        private Brand brand;
        private Integer price;
        private Category category;
        private Integer stockQuantity;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterProductResponse {
        @NotEmpty
        private Long id;
        @NotEmpty
        private String productName;
        @NotEmpty
        private Brand brand;
        @NotEmpty
        private Integer price;
        @NotEmpty
        private Category category;
        @NotEmpty
        private Integer stockQuantity;

        public RegisterProductResponse (Long productId, RegisterProductRequest request) {
            this.id = productId;
            this.productName = request.productName;
            this.brand = request.brand;
            this.price = request.price;
            this.category = request.category;
            this.stockQuantity = request.stockQuantity;
        }
    }
    @Data
    @NoArgsConstructor
    public static class deleteProductResponse {
        @NotEmpty
        private Long id;

        public deleteProductResponse (Long productId) {
            this.id = productId;
        }
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class findByIdResponse {
        private Long id;
        private String productName;
        private Brand brand;
        private Integer price;
        private Category category;
        private Integer stockQuantity;

        public findByIdResponse (ProductEntity productEntity) {
            this.id = productEntity.id;
            this.productName = productEntity.productName;
            this.brand = productEntity.brand;
            this.price = productEntity.price;
            this.category = productEntity.category;
            this.stockQuantity = productEntity.stockQuantity;
        }
    }
}
