package com.app.personalization.controllers;

import com.app.personalization.models.Product;
import com.app.personalization.services.EcommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ecommerce")
public class EcommController {

    private final EcommService shopperProductService;

    EcommController(@Autowired EcommService shopperProductService) {
        this.shopperProductService = shopperProductService;
    }

    @GetMapping("/products")
    public List<Product> getProductsByShopper(
            @RequestParam String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") int limit
    ) {
        return shopperProductService.getProductsByShopper(shopperId, category, brand, limit);
    }
}
