package com.akakce.backend.repository;
import com.akakce.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderByModelNo();
    List<Product> findAllByOrderByFiyat();
    List<Product> findByModelNoOrderByFiyatAsc(String modelNo);
    List<Product> findAllByOrderByMarka();
    List<Product> findAllByOrderById();
    Product deleteProductById(Long id);
    boolean existsById(Long id);
    void deleteById(Long id);
}
