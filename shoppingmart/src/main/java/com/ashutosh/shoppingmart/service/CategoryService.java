package com.ashutosh.shoppingmart.service;

import com.ashutosh.shoppingmart.dto.request.CreateCategoryRequest;
import com.ashutosh.shoppingmart.entity.Category;

import javax.validation.Valid;

public interface CategoryService {
    void addProductCategory(@Valid CreateCategoryRequest createCategoryRequest);
}
