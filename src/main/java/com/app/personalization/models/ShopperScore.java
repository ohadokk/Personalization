package com.app.personalization.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "shopper_score",
        indexes = {
        @Index(name = "index_productId", columnList = "productId"),
        @Index(name = "index_shopperId", columnList = "shopperId")
})
@Builder
@Data
public class ShopperScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String shopperId;
    String productId;
    Double score;
}
