package com.ashutosh.shoppingmart.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CartItemKey implements Serializable {
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "cart_id")
    private Integer cartId;
}
