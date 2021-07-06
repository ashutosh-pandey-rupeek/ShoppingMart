package com.ashutosh.shoppingmart.service;

import com.ashutosh.shoppingmart.dto.request.CreateOfferRequest;
import com.ashutosh.shoppingmart.entity.Offer;

public interface OfferService {
    void addOffer(CreateOfferRequest createOfferRequest);
    Offer getOfferByProductId(Integer productId);
}
