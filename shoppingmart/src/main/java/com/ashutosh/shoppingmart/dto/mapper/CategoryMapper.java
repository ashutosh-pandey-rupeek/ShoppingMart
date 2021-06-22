package com.ashutosh.shoppingmart.dto.mapper;

import com.ashutosh.shoppingmart.dto.request.CreateCategoryRequest;
import com.ashutosh.shoppingmart.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    Category toProductCategory(CreateCategoryRequest createCategoryRequest);
}
