package com.app.personalization.services;

import com.app.personalization.models.Product;
import com.app.personalization.repositories.ProductRepository;
import com.app.personalization.repositories.ShopperScoreProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EcommService {

    private final ShopperScoreProductRepository shopperScoreProductRepository;

    EcommService(@Autowired ShopperScoreProductRepository shopperProductRepository,
                 @Autowired ProductRepository productRepository) {
        this.shopperScoreProductRepository = shopperProductRepository;
    }

    public List<Product> getProductsByShopper(String shopperId, String category, String brand, int limit) {
        if (category == null && brand == null) {
            return shopperScoreProductRepository.findProductOrderedByScore(shopperId).stream()
                    .limit(limit)
                    .toList();
        } else if (category == null) {
            return shopperScoreProductRepository.findByIdShopperIdAndProductBrand(shopperId, brand).stream()
                    .limit(limit)
                    .toList();
        } else if (brand == null) {
            return shopperScoreProductRepository.findByIdShopperIdAndProductCategory(shopperId, category).stream()
                    .limit(limit)
                    .toList();
        } else {
            return shopperScoreProductRepository.findByIdShopperIdAndProductCategoryAndProductBrand(shopperId, category, brand).stream()
                    .limit(limit)
                    .toList();
        }
    }
}
