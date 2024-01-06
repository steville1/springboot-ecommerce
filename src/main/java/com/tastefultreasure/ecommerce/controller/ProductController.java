package com.tastefultreasure.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tastefultreasure.ecommerce.entity.Product;
import com.tastefultreasure.ecommerce.service.ProductProjection;
import com.tastefultreasure.ecommerce.service.ProductService;

@RestController
@RequestMapping("/v1/api/products")
@CrossOrigin("http://localhost:4200")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseBody
    public Map<String, List<ProductProjection>> getAllProducts() {
        Map<String, List<ProductProjection>> response = new HashMap<>();
        response.put("products", productService.getAllProducts());
        return response;
    }

}
