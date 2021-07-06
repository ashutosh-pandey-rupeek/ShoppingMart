package com.ashutosh.shoppingmart.exception;

import com.ashutosh.shoppingmart.dto.response.ApiResponse;
import com.ashutosh.shoppingmart.dto.response.ErrorResponse;
import com.ashutosh.shoppingmart.utility.ShoppingMartErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static HttpHeaders getRequiredHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @ExceptionHandler(ShoppingMartException.class)
    protected ResponseEntity<Object> handleCustomExceptions(ShoppingMartException exception,
                                                            WebRequest request) {
        return handleException(exception, request, exception.getErrorResponse(), null);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldValidationError> fieldErrors = exception.getBindingResult().getFieldErrors().stream()
                .map(e -> new FieldValidationError(e.getField(), e.getDefaultMessage())).collect(Collectors.toList());
        return handleException(exception, request, ShoppingMartErrorResponse.INVALID_REQUEST, fieldErrors);
    }

    private ResponseEntity<Object> handleException(ShoppingMartException exception, WebRequest request,
                                                   ErrorResponse errorResponse, Object validations) {
        return handleExceptionInternal(exception,
                new ApiResponse<>(errorResponse.getHttpStatus(), exception.getCode(),
                        errorResponse.getMessage(), validations),
                getRequiredHeaders(), errorResponse.getHttpStatus(), request);
    }

    private ResponseEntity<Object> handleException(Exception exception, WebRequest request, ErrorResponse errorResponse,
                                                   Object validations) {
        return handleExceptionInternal(exception,
                new ApiResponse<>(errorResponse.getHttpStatus(), errorResponse.getCode(),
                        errorResponse.getMessage(), validations),
                getRequiredHeaders(), errorResponse.getHttpStatus(), request);
    }
}
