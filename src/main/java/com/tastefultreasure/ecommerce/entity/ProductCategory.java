package com.tastefultreasure.ecommerce.entity;

import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;

    // Getter for 'id'
    public Long getId() {
        return id;
    }

    // Setter for 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for 'categoryName'
    public String getCategoryName() {
        return categoryName;
    }

    // Setter for 'categoryName'
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    // Getter for 'products'
    public Set<Product> getProducts() {
        return products;
    }

    // Setter for 'products'
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
