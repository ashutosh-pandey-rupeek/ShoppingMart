package com.ashutosh.shoppingmart.repository;

import com.ashutosh.shoppingmart.entity.Offer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaSpecificationExecutor<Offer>, PagingAndSortingRepository<Offer, Integer> {
    Offer findByProductId(Integer productId);

    @Query(value = "select * from offer where product_id in (:productIds)", nativeQuery = true)
    List<Offer> findByProductIds(@Param("productIds") List<Integer> productIds);
}
