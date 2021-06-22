package com.ashutosh.shoppingmart.service.impl;

import com.ashutosh.shoppingmart.dto.mapper.OfferMapper;
import com.ashutosh.shoppingmart.dto.request.CreateOfferRequest;
import com.ashutosh.shoppingmart.entity.Offer;
import com.ashutosh.shoppingmart.entity.Product;
import com.ashutosh.shoppingmart.repository.OfferRepository;
import com.ashutosh.shoppingmart.service.OfferService;
import com.ashutosh.shoppingmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    OfferMapper offerMapper;

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    ProductService productService;

    @Override
    public void addOffer(CreateOfferRequest createOfferRequest) {
        Product product = productService.getProductById(createOfferRequest.getProductId());
        Offer offer = offerMapper.toOffer(createOfferRequest);
        offer.setProduct(product);
        offerRepository.save(offer);
    }
}
