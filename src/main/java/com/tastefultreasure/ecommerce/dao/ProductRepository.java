package com.tastefultreasure.ecommerce.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tastefultreasure.ecommerce.entity.Product;
import com.tastefultreasure.ecommerce.service.ProductProjection;

@CrossOrigin("http://localhost:4200")
@Repository
//@RepositoryRestResource(collectionResourceRel = "product", path="products")
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("SELECT p.id AS id, p.name AS name, p.sku As sku, p.description As description, p.unitPrice As unitPrice,p.imageUrl As imageUrl FROM Product p")
	    List<ProductProjection> findAllProjected();
}
