package com.ashutosh.shoppingmart.service;

import com.ashutosh.shoppingmart.dto.request.CreateProductRequest;
import com.ashutosh.shoppingmart.dto.response.ProductDto;
import com.ashutosh.shoppingmart.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

public interface ProductService {

    void addProduct(@Valid CreateProductRequest createProductRequestDTO);
    ProductDto getProductDtoById(Integer id);
    Product getProductById(Integer id);

    Page<ProductDto> getProductDtos(Pageable pageable);
}
