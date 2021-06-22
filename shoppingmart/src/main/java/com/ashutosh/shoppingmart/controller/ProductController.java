package com.ashutosh.shoppingmart.controller;

import com.ashutosh.shoppingmart.dto.request.CreateProductRequest;
import com.ashutosh.shoppingmart.dto.response.ApiResponse;
import com.ashutosh.shoppingmart.dto.response.ProductDto;
import com.ashutosh.shoppingmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {
    private static final String ADDED_PRODUCT_SUCCESSFULLY = "Successfully added product";
    private static final String PRODUCT_CREATION_SUCCESS = "PRODUCT_CREATION_SUCCESS";
    private static final String FETCHED_PRODUCT_SUCCESSFULLY = "Successfully fetched product by Id";
    private static final String PRODUCT_FETCH_SUCCESS = "PRODUCT_FETCH_SUCCESS";

    @Autowired
    ProductService productService;

    @PostMapping
    public ApiResponse addProducts(@Valid @RequestBody CreateProductRequest createProductRequest){
        productService.addProduct(createProductRequest);
        return ApiResponse.builder().code(PRODUCT_CREATION_SUCCESS).message(ADDED_PRODUCT_SUCCESSFULLY)
                .status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductDto> getProductById(@PathVariable(name = "id") Integer id){
        return ApiResponse.<ProductDto>builder().message(FETCHED_PRODUCT_SUCCESSFULLY).status(HttpStatus.OK).
                code(PRODUCT_FETCH_SUCCESS).data(productService.getProductDtoById(id)).build();
    }

    @GetMapping()
    public ApiResponse<Page<ProductDto>> getProducts(Pageable pageable){
        return ApiResponse.<Page<ProductDto>>builder().message(FETCHED_PRODUCT_SUCCESSFULLY).status(HttpStatus.OK).
                code(PRODUCT_FETCH_SUCCESS).data(productService.getProductDtos(pageable)).build();
    }
}
