package com.app.personalization.repositories;

import com.app.personalization.models.Product;
import com.app.personalization.models.ShopperScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopperScoreProductRepository extends JpaRepository<ShopperScore, String> {

    @Query("SELECT p " +
            "FROM ShopperScore s " +
            "JOIN Product p ON s.productId = p.productId " +
            "WHERE s.shopperId = :shopperId " +
            "ORDER BY s.score DESC")
    List<Product> findProductOrderedByScore(String shopperId);

    @Query("SELECT p " +
            "FROM ShopperScore s " +
            "JOIN Product p ON s.productId = p.productId " +
            "WHERE s.shopperId = :shopperId AND p.brand = :brand " +
            "ORDER BY s.score DESC")
    List<Product> findByIdShopperIdAndProductBrand(String shopperId, String brand);

    @Query("SELECT p " +
            "FROM ShopperScore s " +
            "JOIN Product p ON s.productId = p.productId " +
            "WHERE s.shopperId = :shopperId AND p.category = :category " +
            "ORDER BY s.score DESC")
    List<Product> findByIdShopperIdAndProductCategory(String shopperId, String category);

    @Query("SELECT p " +
            "FROM ShopperScore s " +
            "JOIN Product p ON s.productId = p.productId " +
            "WHERE s.shopperId = :shopperId AND p.category = :category AND p.brand = :brand " +
            "ORDER BY s.score DESC")
    List<Product> findByIdShopperIdAndProductCategoryAndProductBrand(String shopperId, String category, String brand);
}
