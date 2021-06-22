package com.ashutosh.shoppingmart.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FieldValidationError implements Serializable {
    private static final long serialVersionUID = 1L;

    private String field;
    private String message;

    public FieldValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
