package com.tastefultreasure.ecommerce.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    // Getter for 'id'
    public Long getId() {
        return id;
    }

    // Setter for 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for 'category'
    public ProductCategory getCategory() {
        return category;
    }

    // Setter for 'category'
    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    
    // Getter for 'name'
    public String getName() {
        return name;
    }
    // Setter for 'name'
    public void setName(String name) {
        this.name = name;
    }
    //Getter for unitPrice
    public BigDecimal getUnitPrice() {
    	return unitPrice;
    }
    //Setter
    public void setUnitPrice(BigDecimal unitPrice) {
    	this.unitPrice = unitPrice;
    }
    // Getter for 'sku'
    public String getSku() {
        return sku;
    }
    
  //Setter
    public void setImageUrl(String imageUrl) {
    	this.imageUrl = imageUrl;
    }
    // Getter for 'imgageUrl'
    public String getImageUrl() {
        return imageUrl;
    }

    // Setter for sku
    public void setSku(String sku) {
        this.sku = sku;
    }

    // Repeat the same pattern for other fields...

    // Getter for 'dateCreated'
    public Date getDateCreated() {
        return dateCreated;
    }

    // Setter for 'dateCreated'
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    // Getter for 'lastUpdated'
    public Date getLastUpdated() {
        return lastUpdated;
    }

    // Setter for 'lastUpdated'
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}