package com.ashutosh.shoppingmart.repository;

import com.ashutosh.shoppingmart.entity.Cart;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaSpecificationExecutor<Cart>, PagingAndSortingRepository<Cart,Integer> {
}
