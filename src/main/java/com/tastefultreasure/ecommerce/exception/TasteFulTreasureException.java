package com.tastefultreasure.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class TasteFulTreasureException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public TasteFulTreasureException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public TasteFulTreasureException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
