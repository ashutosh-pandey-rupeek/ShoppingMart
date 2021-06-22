package com.ashutosh.shoppingmart.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    @NotBlank
    private String name;

    @NotNull
    private Integer categoryId;

    @NotNull
    private Integer quantity;

    @NotNull
    private double price;
}
