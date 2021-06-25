package com.ashutosh.shoppingmart.exception;

import com.ashutosh.shoppingmart.dto.response.ErrorResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingMartException extends RuntimeException{
    private final String code;
    private final ErrorResponse errorResponse;

    public ShoppingMartException(String code, ErrorResponse errorResponse) {
        this.code = code;
        this.errorResponse = errorResponse;
    }

    /*public ShoppingMartException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }*/
}
