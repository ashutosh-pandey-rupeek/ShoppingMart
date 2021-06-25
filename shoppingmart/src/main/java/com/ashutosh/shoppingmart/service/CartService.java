package com.ashutosh.shoppingmart.service;

import com.ashutosh.shoppingmart.dto.request.AddToCartRequest;
import com.ashutosh.shoppingmart.dto.request.UpdateCartItemRequest;
import com.ashutosh.shoppingmart.dto.response.CartItemsDto;
import com.ashutosh.shoppingmart.entity.Product;


public interface CartService {
    void addToCart(AddToCartRequest addToCartRequest, Product product);

    CartItemsDto getListOfItems(Integer id);

    void updateItemInCart(UpdateCartItemRequest updateCartItemRequest, Integer id);

    void deleteItemInCart(Integer id);

    // TODO: CartItemsDto getItemsInCartWithAppliedOffers(Integer id);
}
