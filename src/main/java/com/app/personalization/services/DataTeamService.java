package com.app.personalization.services;

import com.app.personalization.models.Product;
import com.app.personalization.models.ProductScore;
import com.app.personalization.models.ScoreRequestBody;
import com.app.personalization.models.ShopperScore;
import com.app.personalization.repositories.ProductRepository;
import com.app.personalization.repositories.ShopperScoreProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataTeamService {

    private final ProductRepository productRepository;
    private final ShopperScoreProductRepository shopperProductRepository;

    DataTeamService(@Autowired ProductRepository productRepository, @Autowired ShopperScoreProductRepository shopperProductRepository) {
        this.productRepository = productRepository;
        this.shopperProductRepository = shopperProductRepository;
    }

    public List<Product> addProducts(List<Product> product) {
        return productRepository.saveAll(product);
    }

    public List<ShopperScore> addShopperProducts(List<ScoreRequestBody> body) {
        List<ShopperScore> result = new ArrayList<>();
        for (ScoreRequestBody productScores : body) {
            for (ProductScore score : productScores.getShelf()) {
                ShopperScore shopperScore = ShopperScore.builder()
                        .shopperId(productScores.getShopperId())
                        .score(score.getRelevancyScore())
                        .productId(score.getProductId()).build();
                result.add(shopperScore);
            }
        }

        return shopperProductRepository.saveAll(result);
    }
}
