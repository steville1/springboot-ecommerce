package com.tastefultreasure.ecommerce.service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.tastefultreasure.ecommerce.dto.PaymentInfo;
import com.tastefultreasure.ecommerce.dto.Purchase;
import com.tastefultreasure.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);
	PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}