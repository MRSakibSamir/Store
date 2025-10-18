package com.retail.store.service;

import com.retail.store.entity.Products;
import com.retail.store.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public Optional<Products> getProductById(Long id) {
        return productsRepository.findById(id);
    }

    public Products createProduct(Products product) {
        return productsRepository.save(product);
    }

    public Products updateProduct(Long id, Products updatedProduct) {
        return productsRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedProduct.getName());
                    existing.setDescription(updatedProduct.getDescription());
                    existing.setPrice(updatedProduct.getPrice());
                    existing.setQuantity(updatedProduct.getQuantity());
                    existing.setCategory(updatedProduct.getCategory());
                    return productsRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }
}
