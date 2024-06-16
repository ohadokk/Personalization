package com.app.personalization.models;

import lombok.Data;

import java.util.List;

@Data
public class ScoreRequestBody {
    String shopperId;
    List<ProductScore> shelf;
}
