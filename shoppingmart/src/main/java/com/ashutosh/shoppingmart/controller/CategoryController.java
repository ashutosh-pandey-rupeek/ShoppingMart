package com.ashutosh.shoppingmart.controller;

import com.ashutosh.shoppingmart.dto.request.CreateCategoryRequest;
import com.ashutosh.shoppingmart.dto.response.ApiResponse;
import com.ashutosh.shoppingmart.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/category")
public class CategoryController {
    private static final String ADDED_CATEGORY_SUCCESSFULLY = "Added product category successfully";
    private static final String CATEGORY_CREATION_SUCCESS = "CATEGORY_CREATION_SUCCESS";

    @Autowired
    CategoryServiceImpl categoryService;

    @PostMapping
    public ApiResponse addProducts(@Valid @RequestBody CreateCategoryRequest createCategoryRequest){
        categoryService.addProductCategory(createCategoryRequest);
        return ApiResponse.builder().code(CATEGORY_CREATION_SUCCESS).message(ADDED_CATEGORY_SUCCESSFULLY).
                status(HttpStatus.CREATED).build();
        //new ApiResponse(ADDED_CATEGORY_SUCCESSFULLY, HttpStatus.CREATED);
    }
}
