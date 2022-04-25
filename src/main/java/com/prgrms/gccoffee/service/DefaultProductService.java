package com.prgrms.gccoffee.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.prgrms.gccoffee.model.Category;
import com.prgrms.gccoffee.model.Product;
import com.prgrms.gccoffee.repository.ProductRepostitory;

public class DefaultProductService implements ProductService {

    private final ProductRepostitory productRepostitory;

    public DefaultProductService(ProductRepostitory productRepostitory) {
        this.productRepostitory = productRepostitory;
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return productRepostitory.findByCategory(category);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepostitory.findAll();
    }

    @Override
    public Product createProduct(String productName, Category catergory, long price) {
        Product product = new Product(UUID.randomUUID(), productName, catergory, price);
        return productRepostitory.insert(product);
    }

    @Override
    public Product createProduct(String productName, Category catergory, long price, String description) {
        Product product = new Product(UUID.randomUUID(), productName, catergory, price, description,
            LocalDateTime.now(), LocalDateTime.now());
        return productRepostitory.insert(product);
    }
}
