package com.app.appmarket.persistence;

import com.app.appmarket.domain.ProductDomain;
import com.app.appmarket.domain.repositories.IProductRepository;
import com.app.appmarket.persistence.crud.IProductCrudRepository;
import com.app.appmarket.persistence.entities.Product;
import com.app.appmarket.persistence.mapper.IProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private IProductCrudRepository IProductCrudRepository;

    @Autowired
    private IProductMapper mapper;

    @Override
    public List<ProductDomain> getAll() {
        List<Product> products = (List<Product>) IProductCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<ProductDomain>> getByCategory(int categoryId) {
        List<Product> products = IProductCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<ProductDomain>> getScarseProducts(int quantity) {
        Optional<List<Product>> products = IProductCrudRepository.findByStockQuantityLessThanAndStatus(quantity, true);
        return products.map(product -> mapper.toProducts(product));
    }

    @Override
    public Optional<ProductDomain> getProduct(int productId) {
        return IProductCrudRepository.findById(productId).map(product -> mapper.toProduct(product));
    }

    @Override
    public ProductDomain save(ProductDomain product) {
        Product prod = mapper.toProducto(product);
        return mapper.toProduct(IProductCrudRepository.save(prod));
    }

    @Override
    public void delete(int productId) {
        IProductCrudRepository.deleteById(productId);
    }

}
