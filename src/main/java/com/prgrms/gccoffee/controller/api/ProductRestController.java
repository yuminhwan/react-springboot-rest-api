package com.prgrms.gccoffee.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prgrms.gccoffee.model.Category;
import com.prgrms.gccoffee.model.Product;
import com.prgrms.gccoffee.service.ProductService;

@RestController
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/v1/products")
    public List<Product> productList(@RequestParam Optional<Category> category) {
        return category
            .map(productService::getProductsByCategory)
            .orElse(productService.getAllProducts());
    }
}
