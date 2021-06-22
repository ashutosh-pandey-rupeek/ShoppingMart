package com.ashutosh.shoppingmart.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( nullable = false )
    @Enumerated(EnumType.STRING)
    private DiscountCategory discountCategory;

    private double discountValue;

    private boolean enabled;

    private Integer minItems;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product;
}
