package com.tastefultreasure.ecommerce.service;

import java.math.BigDecimal;
import java.util.Date;

public interface ProductProjection {
    
Long getId();

String getSku();

String getName();
String getDescription();

BigDecimal getUnitPrice();

String getImageUrl();

//int getUnitsInStock();
//Date getDateCreated();
//Date getLastUpdated();
}
