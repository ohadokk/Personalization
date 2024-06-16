package com.app.personalization.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(indexes = {
        @Index(name = "index_category", columnList = "category"),
        @Index(name = "index_brand", columnList = "brand")
})
public class Product {
    @Id
    private String productId;
    private String category;
    private String brand;
}
