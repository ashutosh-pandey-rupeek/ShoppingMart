package com.ashutosh.shoppingmart.service.impl;

import com.ashutosh.shoppingmart.dto.mapper.ProductMapper;
import com.ashutosh.shoppingmart.dto.request.CreateProductRequest;
import com.ashutosh.shoppingmart.dto.response.ProductDto;
import com.ashutosh.shoppingmart.entity.Category;
import com.ashutosh.shoppingmart.entity.Product;
import com.ashutosh.shoppingmart.exception.ShoppingMartException;
import com.ashutosh.shoppingmart.repository.CategoryRepository;
import com.ashutosh.shoppingmart.repository.ProductRepository;
import com.ashutosh.shoppingmart.service.ProductService;
import com.ashutosh.shoppingmart.utility.ShoppingMartErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private static final String PRODUCT_CATEGORY_NOT_FOUND = "PRODUCT_CATEGORY_NOT_FOUND";
    private static final String PRODUCT_DUPLICATE = "PRODUCT_DUPLICATE";
    private static final String PRODUCT_NOT_FOUND = "PRODUCT_NOT_FOUND";

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductMapper productMapper;

    @Override
    public void addProduct(@Valid CreateProductRequest createProductRequestDTO) {
        Category productCategory = categoryRepository.findById(createProductRequestDTO.getCategoryId()).
                orElseThrow(() -> new ShoppingMartException(PRODUCT_CATEGORY_NOT_FOUND, ShoppingMartErrorResponse.PRODUCT_CATEGORY_NOT_FOUND));

        Optional<Product> product = productRepository.findByName(createProductRequestDTO.getName());
        if(product.isPresent()){
            throw new ShoppingMartException(PRODUCT_DUPLICATE, ShoppingMartErrorResponse.PRODUCT_DUPLICATE);
        }

        Product newProduct = productMapper.toProduct(createProductRequestDTO);
        newProduct.setCategory(productCategory);
        productRepository.save(newProduct);
    }

    @Override
    public ProductDto getProductDtoById(Integer id) {
        return productRepository.findById(id).map(product -> productMapper.toProductDto(product)).orElseThrow(
                () -> new ShoppingMartException(PRODUCT_NOT_FOUND, ShoppingMartErrorResponse.PRODUCT_NOT_FOUND));
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(
                () -> new ShoppingMartException(PRODUCT_NOT_FOUND, ShoppingMartErrorResponse.PRODUCT_NOT_FOUND));
    }

    @Override
    public Page<ProductDto> getProductDtos(org.springframework.data.domain.Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(product -> productMapper.toProductDto(product));
    }
}
