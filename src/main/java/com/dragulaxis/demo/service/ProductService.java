package com.dragulaxis.demo.service;

import com.dragulaxis.demo.entity.Product;
import com.dragulaxis.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveOrUpdateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Page<Product> getProductWithPaginationAndFiltration(Specification<Product> specifications, Pageable pageable) {
        return productRepository.findAll(specifications, pageable);
    }
}
