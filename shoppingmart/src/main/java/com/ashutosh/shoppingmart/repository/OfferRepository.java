package com.ashutosh.shoppingmart.repository;

import com.ashutosh.shoppingmart.entity.Offer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaSpecificationExecutor<Offer>, PagingAndSortingRepository<Offer, Integer> {
}
