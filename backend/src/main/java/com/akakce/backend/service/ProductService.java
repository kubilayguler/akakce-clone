package com.akakce.backend.service;

import com.akakce.backend.entity.Product;
import com.akakce.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> preventDuplicateProducts() {
        List<Product> existingProducts = productRepository.findAllByOrderByModelNo();
        for (int i = 0; i< existingProducts.size()-1; i++) {
            if(existingProducts.get(i).getModelNo().equals(existingProducts.get(i+1).getModelNo())) {
                    existingProducts.remove(i);
            }
        }
        return existingProducts;
    }
    public List<Product> getProductsByModelNo(String modelNo) {
        return productRepository.findByModelNoOrderByFiyatAsc(modelNo);
    }
    public List<Product> getProducts() {
       // return productRepository.findAllByOrderByMarka();
        return productRepository.findAllByOrderById();
    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            System.out.println("Product not found with id " + id);
        }
    }
}