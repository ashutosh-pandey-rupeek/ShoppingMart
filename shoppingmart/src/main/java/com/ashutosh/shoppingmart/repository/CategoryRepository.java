package com.ashutosh.shoppingmart.repository;

import com.ashutosh.shoppingmart.entity.Category;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaSpecificationExecutor<Category> , PagingAndSortingRepository<Category, Integer> {
    Optional<Category> findByName(String name);
}
