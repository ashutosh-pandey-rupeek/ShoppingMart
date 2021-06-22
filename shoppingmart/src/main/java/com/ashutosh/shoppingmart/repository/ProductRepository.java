package com.ashutosh.shoppingmart.repository;

import com.ashutosh.shoppingmart.entity.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaSpecificationExecutor<Product>, PagingAndSortingRepository<Product, Integer> {
    Optional<Product> findByName(String name);
}
