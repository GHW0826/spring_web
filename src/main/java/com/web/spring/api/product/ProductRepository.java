package com.web.spring.api.product;

import com.web.spring.api.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final EntityManager em;

    public void save(ProductEntity product) {
        em.persist(product);
    }

    public Optional<ProductEntity> findById(Long id) {
        ProductEntity product = em.find(ProductEntity.class, id);
        return Optional.ofNullable(product);
    }

    public List<ProductEntity> findAll() {
        return em.createQuery("select p from Product p", ProductEntity.class)
                .getResultList();
    }

    public int updateProductByEntity(ProductEntity productEntity) {
        return updateProduct(productEntity.getId(), productEntity.getProductName(), productEntity.getBrand(), productEntity.getPrice(), productEntity.getCategory(), productEntity.getStockQuantity());
    }

    public int updateProductByRequestApi(Long productId,ProductEntity.RegisterProductRequest requset) {
        return updateProduct(productId, requset.getProductName(), requset.getBrand(), requset.getPrice(), requset.getCategory(), requset.getStockQuantity());
    }

    public int updateProduct(Long productId, String productName, Brand brand, Integer price, Category category, Integer stockQuantity) {
        return em.createQuery("update Product p " +
                                        "set p.productName = :productName, " +
                                        "p.brand = :brand, " +
                                        "p.price = :price, " +
                                        "p.category = :category, " +
                                        "p.stockQuantity = :stockQuantity " +
                                        "where p.id = :id")
                .setParameter("productName", productName)
                .setParameter("brand", brand)
                .setParameter("price", price)
                .setParameter("category", category)
                .setParameter("stockQuantity", stockQuantity)
                .setParameter("id", productId)
                .executeUpdate();
    }

    public int deleteProduct(Long productId) {
        return em.createQuery("delete from Product p where p.id = :id")
                .setParameter("id", productId)
                .executeUpdate();
    }
}
