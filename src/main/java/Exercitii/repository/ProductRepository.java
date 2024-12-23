package Exercitii.repository;

import Exercitii.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM PRODUCT LIMIT 1", nativeQuery = true)
    List<Product> findAllProductsForUser();


}
