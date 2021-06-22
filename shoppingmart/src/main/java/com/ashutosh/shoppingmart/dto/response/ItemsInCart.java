package com.ashutosh.shoppingmart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
public class ItemsInCart {

    @NotNull
    private Integer quantity;
    @NotNull
    private ProductDto productDto;
}
