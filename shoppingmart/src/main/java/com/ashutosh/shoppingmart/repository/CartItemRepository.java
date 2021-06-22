package com.ashutosh.shoppingmart.repository;

import com.ashutosh.shoppingmart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaSpecificationExecutor<CartItem>, PagingAndSortingRepository<CartItem,Integer> {
    List<CartItem> findByCartId(Integer cartId);
}
