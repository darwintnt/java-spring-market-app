package com.app.appmarket.persistence.mapper;


import com.app.appmarket.domain.ProductDomain;
import com.app.appmarket.persistence.entities.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ICategoryMapper.class})
public interface IProductMapper {

    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "sellingPrice", target = "price"),
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "category", target = "category"),

    })
    ProductDomain toProduct(Product product);
    List<ProductDomain> toProducts(List<Product> products);

   @InheritInverseConfiguration
   @Mapping(target = "barcode", ignore = true)
   Product toProducto(ProductDomain product);


}
