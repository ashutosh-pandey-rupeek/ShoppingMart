package com.ashutosh.shoppingmart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private String code;
    private HttpStatus httpStatus;

    public ErrorResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
