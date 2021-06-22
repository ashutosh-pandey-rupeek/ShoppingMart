package com.ashutosh.shoppingmart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class CartItemsDto {
    private List<ItemsInCart> cartItems;
    private double totalCost;
}
