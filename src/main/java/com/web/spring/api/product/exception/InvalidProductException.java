package com.web.spring.api.product.exception;

public class InvalidProductException extends ProductException {

    public InvalidProductException() {
        super();
    }

    public InvalidProductException(String message) {
        super(message);
    }

    public InvalidProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProductException(Throwable cause) {
        super(cause);
    }
}
