package com.ashutosh.shoppingmart.controller;

import com.ashutosh.shoppingmart.dto.request.AddToCartRequest;
import com.ashutosh.shoppingmart.dto.request.UpdateCartItemRequest;
import com.ashutosh.shoppingmart.dto.response.CartItemsDto;
import com.ashutosh.shoppingmart.dto.response.ApiResponse;
import com.ashutosh.shoppingmart.entity.Product;
import com.ashutosh.shoppingmart.service.CartService;
import com.ashutosh.shoppingmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/carts")
public class CartController {
    private static final String ADDED_TO_CART = "successfully added to cart";
    private static final String CART_ADDITION_SUCCESS = "CART_ADDITION_SUCCESS";
    private static final String FETCHED_ITEMS_IN_CART = "successfully fetched items from cart";
    private static final String CART_DETAILS_FETCH_SUCCESS = "CART_DETAILS_FETCH_SUCCESS";
    private static final String UPDATED_CART_ITEM = "successfully updated cart's item";
    private static final String CART_UPDATE_SUCCESS = "CART_UPDATE_SUCCESS";

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public ApiResponse addToCart(@Valid @RequestBody AddToCartRequest addToCartRequest){
        Product product = productService.getProductById(addToCartRequest.getProductId());
        cartService.addToCart(addToCartRequest, product);
        return ApiResponse.builder().code(CART_ADDITION_SUCCESS).message(ADDED_TO_CART).status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ApiResponse<CartItemsDto> getItemsInCart(@PathVariable(name = "id") Integer id){
        return ApiResponse.<CartItemsDto>builder().code(CART_DETAILS_FETCH_SUCCESS).message(FETCHED_ITEMS_IN_CART).status(HttpStatus.OK).
                data(cartService.getListOfItems(id)).build();
    }

    @PutMapping("/{id}")
    public ApiResponse updateItemInCart(@Valid @RequestBody UpdateCartItemRequest updateCartItemRequest,
                                          @PathVariable(name = "id") Integer id){
        cartService.updateItemInCart(updateCartItemRequest, id);
        return ApiResponse.builder().code(CART_UPDATE_SUCCESS).message(UPDATED_CART_ITEM).status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteItemInCart(@PathVariable(name = "id") Integer id){
        cartService.deleteItemInCart(id);
        return ApiResponse.builder().code(CART_UPDATE_SUCCESS).message(UPDATED_CART_ITEM).status(HttpStatus.OK).build();
    }
}
