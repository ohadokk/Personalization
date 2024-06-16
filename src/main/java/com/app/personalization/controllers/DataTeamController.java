package com.app.personalization.controllers;

import com.app.personalization.models.Product;
import com.app.personalization.models.ScoreRequestBody;
import com.app.personalization.models.ShopperScore;
import com.app.personalization.services.DataTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataTeamController {

    private final DataTeamService dataTeamService;

    DataTeamController(@Autowired DataTeamService dataTeamService) {
        this.dataTeamService = dataTeamService;
    }

    @PostMapping("/products")
    public List<Product> addProduct(@RequestBody List<Product> product) {
        return dataTeamService.addProducts(product);
    }

    @PostMapping("/shopper-score")
    public List<ShopperScore> addShopperProduct(@RequestBody List<ScoreRequestBody> shopperProduct) {
        return dataTeamService.addShopperProducts(shopperProduct);
    }
}