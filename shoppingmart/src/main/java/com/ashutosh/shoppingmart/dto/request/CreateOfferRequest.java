package com.ashutosh.shoppingmart.dto.request;

import com.ashutosh.shoppingmart.entity.DiscountCategory;
import com.ashutosh.shoppingmart.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOfferRequest {

    @NotBlank
    private String discountCategory;

    @NotNull
    private double discountValue;

    private boolean enabled = true;

    @NotNull
    private Integer minItems;

    @NotNull
    private Integer productId;
}
