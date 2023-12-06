package com.tastefultreasure.ecommerce.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tastefultreasure.ecommerce.entity.Product;

@RepositoryRestResource(collectionResourceRel = "productCategory", path="product-category")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
