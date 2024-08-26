package com.tastefultreasure.ecommerce.service;

import org.springframework.stereotype.Service;

import com.tastefultreasure.ecommerce.dao.CustomerRepository;
import com.tastefultreasure.ecommerce.dto.Purchase;
import com.tastefultreasure.ecommerce.dto.PurchaseResponse;

@Service
public class CheckoutServiceImplementation implements CheckoutService {
	
	private CustomerRepository customerRepostory;
	
	public CheckoutServiceImplementation(CustomerRepository customerRepostory) {
		this.customerRepostory = customerRepostory;
		
	}

	@Override
	public PurchaseResponse placeOrder(Purchase purchase) {
		// TODO Auto-generated method stub
		return null;
	}

}
