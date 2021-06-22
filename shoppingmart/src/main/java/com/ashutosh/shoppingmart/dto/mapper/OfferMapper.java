package com.ashutosh.shoppingmart.dto.mapper;

import com.ashutosh.shoppingmart.dto.request.CreateOfferRequest;
import com.ashutosh.shoppingmart.entity.Offer;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OfferMapper {
    Offer toOffer(CreateOfferRequest createOfferRequest);
}
