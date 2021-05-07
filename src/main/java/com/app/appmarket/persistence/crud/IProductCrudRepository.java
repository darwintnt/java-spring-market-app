package com.app.appmarket.persistence.crud;

import com.app.appmarket.persistence.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductCrudRepository extends CrudRepository<Product, Integer> {

    // @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Product> findByCategoryIdOrderByNameAsc(int CategoryId);

    Optional<List<Product>> findByStockQuantityLessThanAndStatus(int stockQuantity, boolean status);
}
