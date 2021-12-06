package com.dragulaxis.demo.entity;

import com.dragulaxis.demo.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {
    public static Specification<Product> titleContains(String word) {
        return (Specification<Product>)
                (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.
                                like(root.get("title"), "%" + word + "%");
    }

    public static Specification<Product> priceGreaterThanOrEq(Integer price) {
        return (Specification<Product>)
                (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.
                                greaterThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> priceLessThanOrEq(Integer price) {
        return (Specification<Product>)
                (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.
                                lessThanOrEqualTo(root.get("price"), price);
    }
}
