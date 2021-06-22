package com.ashutosh.shoppingmart.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartRequest {

    @NotNull
    private Integer cartId;
    @NotNull
    private Integer productId;
    @NotNull
    private Integer quantity;
}
