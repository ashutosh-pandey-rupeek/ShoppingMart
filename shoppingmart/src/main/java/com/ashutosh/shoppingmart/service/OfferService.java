package com.ashutosh.shoppingmart.service;

import com.ashutosh.shoppingmart.dto.request.CreateOfferRequest;

public interface OfferService {
    void addOffer(CreateOfferRequest createOfferRequest);
}
