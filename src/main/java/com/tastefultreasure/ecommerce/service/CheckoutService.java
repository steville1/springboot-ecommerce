package com.tastefultreasure.ecommerce.service;

import com.tastefultreasure.ecommerce.dto.Purchase;
import com.tastefultreasure.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);
}
