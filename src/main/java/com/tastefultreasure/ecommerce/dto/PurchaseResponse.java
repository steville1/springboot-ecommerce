package com.tastefultreasure.ecommerce.dto;

public class PurchaseResponse {
	private final String orderTrackingNumber;
	
	/**
	 * final Keyword: The final keyword means the field orderTrackingNumber can only be assigned once, typically in the constructor.
	 * @param orderTrackingNumber
	 */
	// Constructor to initialize the final field
    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    // Getter
    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

}
