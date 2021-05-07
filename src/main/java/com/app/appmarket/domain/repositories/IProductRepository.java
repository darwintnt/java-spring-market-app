package com.app.appmarket.domain.repositories;


import com.app.appmarket.domain.ProductDomain;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {

    List<ProductDomain> getAll();

    Optional<List<ProductDomain>> getByCategory(int categoryId);

    Optional<List<ProductDomain>> getScarseProducts(int quantity);

    Optional<ProductDomain> getProduct(int productId);

    ProductDomain save(ProductDomain product);

    void delete(int productId);

}
