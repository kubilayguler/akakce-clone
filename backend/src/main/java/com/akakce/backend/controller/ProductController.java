package com.akakce.backend.controller;


import com.akakce.backend.entity.Product;
import com.akakce.backend.repository.ProductRepository;
import com.akakce.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public List<Product> fetchProducts(){
        return productService.preventDuplicateProducts();
    }
    @GetMapping("/products/all")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @PostMapping("/products/all")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        if(product != null){
            Product savedProduct = productService.saveProduct(product); // Servis katmanı üzerinden kayıt işlemi
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/products/model/{modelNo}")
    public List<Product> getProductsByModelNo(@PathVariable String modelNo) {
        return productService.getProductsByModelNo(modelNo);
    }
}
