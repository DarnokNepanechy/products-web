package com.dragulaxis.demo.controller;

import com.dragulaxis.demo.entity.Product;
import com.dragulaxis.demo.service.ProductService;
import com.dragulaxis.demo.entity.ProductSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProducts(Model model,
                              @RequestParam(value = "word", required = false) String word,
                              @RequestParam(value = "minPrice", required = false) Integer minPrice,
                              @RequestParam(value = "maxPrice", required = false) Integer maxPrice) {

        Specification<Product> specification = Specification.where(null);
        if (word != null) {
            specification = specification.and(ProductSpecifications.titleContains(word));
        }
        if (minPrice != null) {
            specification = specification.and(ProductSpecifications.priceGreaterThanOrEq(minPrice));
        }
        if (maxPrice != null) {
            specification = specification.and(ProductSpecifications.priceLessThanOrEq(maxPrice));
        }

        Product product = new Product();
        model.addAttribute("products",
                productService.getProductWithPaginationAndFiltration(
                        specification, PageRequest.of(0, 100)).getContent());
        model.addAttribute("product", product);
        model.addAttribute("word", word);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "products";
    }

    @GetMapping("/show/{id}")
    public String showOneProduct(Model model, @PathVariable("id") Long id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product-page";
    }

    //TODO: get запрос не должен менять состояние данных (1)
    @GetMapping("/edit/{id}")
    public String editProduct(Model model, @PathVariable("id") Long id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product-edit";
    }

    @PostMapping("/edit")
    public String addNewProduct(@ModelAttribute(value = "product") Product product) {
        productService.saveOrUpdateProduct(product);
        return "redirect:/products";
    }

    //TODO: get запрос не должен менять состояние данных (2)
    @GetMapping(path = "/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteById(productId);
        return "redirect:/products";
    }

    //TODO: get запрос не должен менять состояние данных (3)
    @GetMapping("/add")
    public String openAddProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-edit";
    }
}
