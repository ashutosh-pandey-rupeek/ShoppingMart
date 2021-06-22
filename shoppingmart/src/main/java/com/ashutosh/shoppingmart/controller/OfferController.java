package com.ashutosh.shoppingmart.controller;

import com.ashutosh.shoppingmart.dto.request.CreateOfferRequest;
import com.ashutosh.shoppingmart.dto.response.ApiResponse;
import com.ashutosh.shoppingmart.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/offers")
public class OfferController {

    private static final String ADDED_OFFER_SUCCESSFULLY = "Successfully added offer";
    private static final String OFFER_CREATION_SUCCESS = "OFFER_CREATION_SUCCESS";

    @Autowired
    OfferService offerService;

    @PostMapping
    public ApiResponse addOffer(@Valid @RequestBody CreateOfferRequest createOfferRequest){
        offerService.addOffer(createOfferRequest);
        return ApiResponse.builder().message(ADDED_OFFER_SUCCESSFULLY).status(HttpStatus.CREATED)
                .code(OFFER_CREATION_SUCCESS).build();
    }
}
