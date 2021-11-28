package com.dragulaxis.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends
        JpaSpecificationExecutor<Product>,
        JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.title = ?1")
    Optional<Product> findProductByTitle(String title);

}
