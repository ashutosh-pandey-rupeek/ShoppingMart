package com.ashutosh.shoppingmart.exception;

public class ShoppingMartException extends RuntimeException{
    private Integer code;
    public ShoppingMartException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ShoppingMartException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }
}
