package com.tastefultreasure.ecommerce.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tastefultreasure.ecommerce.dao.CustomerRepository;
import com.tastefultreasure.ecommerce.dto.Purchase;
import com.tastefultreasure.ecommerce.dto.PurchaseResponse;
import com.tastefultreasure.ecommerce.entity.Customer;
import com.tastefultreasure.ecommerce.entity.Order;
import com.tastefultreasure.ecommerce.entity.OrderItem;

import jakarta.transaction.Transactional;

@Service
public class CheckoutServiceImplementation implements CheckoutService {
	
	private CustomerRepository customerRepository;
	
	public CheckoutServiceImplementation(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		// retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        
        //check if this is an existing customer
        String theEmail = customer.getEmail();
        
        Customer customerfromDB = customerRepository.findByEmail(theEmail);
        
        if(customerfromDB != null) {
        	//we found them lets assign them accordingly
        	customer = customerfromDB;
        }
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        return UUID.randomUUID().toString();
    }

}
