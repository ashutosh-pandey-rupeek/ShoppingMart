package com.ashutosh.shoppingmart.utility;

import com.ashutosh.shoppingmart.dto.response.ErrorResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

@UtilityClass
public class ShoppingMartErrorResponse {

    // Cart and CartItem
    public static final ErrorResponse  CART_NOT_FOUND = new ErrorResponse("cart with given carId not found",
            HttpStatus.BAD_REQUEST);
    public static final ErrorResponse  CART_ITEM_NOT_FOUND = new ErrorResponse("no product added in cart",
            HttpStatus.BAD_REQUEST);

    // Product Category
    public static final ErrorResponse PRODUCT_CATEGORY_DUPLICATE = new ErrorResponse("Product Category with provided name already exists",
            HttpStatus.BAD_REQUEST);
    public static final ErrorResponse PRODUCT_CATEGORY_NOT_FOUND = new ErrorResponse("Product Category with provided id not found",
            HttpStatus.BAD_REQUEST);

    // Product
    public static final ErrorResponse PRODUCT_DUPLICATE = new ErrorResponse("Product with provided name already exists",
            HttpStatus.BAD_REQUEST);
    public static final ErrorResponse PRODUCT_NOT_FOUND = new ErrorResponse("Product with provided Id not found",
            HttpStatus.NOT_FOUND);
    public static final ErrorResponse INVALID_REQUEST = new ErrorResponse(
            "Invalid Request. Mandatory field(s) are missing", "LFS_INVALID_REQUEST", HttpStatus.BAD_REQUEST);
}
