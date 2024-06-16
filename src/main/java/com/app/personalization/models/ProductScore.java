package com.app.personalization.models;

import lombok.Data;

@Data
public class ProductScore {
    String productId;
    Double relevancyScore;
}
