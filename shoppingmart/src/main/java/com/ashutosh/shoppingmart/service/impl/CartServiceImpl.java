package com.ashutosh.shoppingmart.service.impl;

import com.ashutosh.shoppingmart.dto.request.AddToCartRequest;
import com.ashutosh.shoppingmart.dto.request.UpdateCartItemRequest;
import com.ashutosh.shoppingmart.dto.response.CartItemsDto;
import com.ashutosh.shoppingmart.dto.response.ItemsInCart;
import com.ashutosh.shoppingmart.entity.Cart;
import com.ashutosh.shoppingmart.entity.CartItem;
import com.ashutosh.shoppingmart.entity.Product;
import com.ashutosh.shoppingmart.exception.ShoppingMartException;
import com.ashutosh.shoppingmart.repository.CartItemRepository;
import com.ashutosh.shoppingmart.repository.CartRepository;
import com.ashutosh.shoppingmart.service.CartService;
import com.ashutosh.shoppingmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private static final String CART_NOT_FOUND = "cart with given carId not found";
    private static final String CART_ITEM_NOT_FOUND = "no product added in cart";

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ProductService productService;

    @Override
    public void addToCart(AddToCartRequest addToCartRequest, Product product) {
        Cart cart = cartRepository.findById(addToCartRequest.getCartId()).orElseThrow(
                ()-> new ShoppingMartException(CART_NOT_FOUND,HttpStatus.BAD_REQUEST.value())
        );
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(addToCartRequest.getQuantity());
        cartItem.setPrice(addToCartRequest.getQuantity()*product.getPrice());
        cartItemRepository.save(cartItem);
    }

    @Override
    public CartItemsDto getListOfItems(Integer id) {
        Cart cart = cartRepository.findById(id).orElseThrow(
                ()-> new ShoppingMartException(CART_NOT_FOUND,HttpStatus.BAD_REQUEST.value()));
        List<CartItem> cartItems = cartItemRepository.findByCartId(id);
        if(cartItems.isEmpty()){
            throw new ShoppingMartException(CART_ITEM_NOT_FOUND,HttpStatus.BAD_REQUEST.value());
        }
        List<ItemsInCart> itemsInCart = new ArrayList<>();
        double totalCost = 0;
        for(CartItem cartItem : cartItems){
           totalCost += cartItem.getPrice();
            itemsInCart.add(new ItemsInCart(cartItem.getQuantity(), productService.getProductDtoById(cartItem.getProduct().getId())));
        }
        return new CartItemsDto(itemsInCart, totalCost);
    }

    @Override
    public void updateItemInCart(UpdateCartItemRequest updateCartItemRequest, Integer id) {
        CartItem cartItem = cartItemRepository.findById(id).orElseThrow(
                () ->  new ShoppingMartException(CART_ITEM_NOT_FOUND,HttpStatus.BAD_REQUEST.value()));
        cartItem.setQuantity(updateCartItemRequest.getQuantity());
        cartItem.setPrice(updateCartItemRequest.getQuantity()*cartItem.getPrice());
        cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteItemInCart(Integer id) {
        CartItem cartItem = cartItemRepository.findById(id).orElseThrow(
                () ->  new ShoppingMartException(CART_ITEM_NOT_FOUND,HttpStatus.BAD_REQUEST.value()));
        cartItemRepository.delete(cartItem);
    }

}
