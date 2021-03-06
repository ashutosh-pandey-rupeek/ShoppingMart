package com.ashutosh.shoppingmart.service.impl;

import com.ashutosh.shoppingmart.dto.mapper.CategoryMapper;
import com.ashutosh.shoppingmart.dto.request.CreateCategoryRequest;
import com.ashutosh.shoppingmart.entity.Category;
import com.ashutosh.shoppingmart.exception.ShoppingMartException;
import com.ashutosh.shoppingmart.repository.CategoryRepository;
import com.ashutosh.shoppingmart.service.CategoryService;
import com.ashutosh.shoppingmart.utility.ShoppingMartErrorResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private static final String PRODUCT_CATEGORY_DUPLICATE = "PRODUCT_CATEGORY_DUPLICATE";

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper productCategoryMapper;

    @Override
    public void addProductCategory(@Valid CreateCategoryRequest createCategoryRequest) {
        Optional<Category> category = categoryRepository.findByName(createCategoryRequest.getName());
        if(category.isPresent()){
            throw new ShoppingMartException(PRODUCT_CATEGORY_DUPLICATE, ShoppingMartErrorResponse.PRODUCT_CATEGORY_DUPLICATE);
        }
        Category newCategory = productCategoryMapper.toProductCategory(createCategoryRequest);
        categoryRepository.save(newCategory);
    }
}
