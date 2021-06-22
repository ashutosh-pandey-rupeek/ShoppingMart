package com.ashutosh.shoppingmart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
    private HttpStatus status;
    private String message;
    private String code;
    private T data;

    public ApiResponse(String message, HttpStatus status){
        this.message = message;
        this.status = status;
    }
}
