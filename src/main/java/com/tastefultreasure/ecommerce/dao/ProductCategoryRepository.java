package com.tastefultreasure.ecommerce.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tastefultreasure.ecommerce.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
