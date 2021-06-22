package com.ashutosh.shoppingmart.dto.mapper;

import com.ashutosh.shoppingmart.dto.request.CreateProductRequest;
import com.ashutosh.shoppingmart.dto.response.ProductDto;
import com.ashutosh.shoppingmart.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    Product toProduct(CreateProductRequest createProductRequest);

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toProductDto(Product product);
}
