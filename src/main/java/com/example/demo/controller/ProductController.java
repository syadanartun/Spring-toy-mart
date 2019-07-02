package com.example.demo.controller;


import com.example.demo.repository.ProductRepository;
import com.example.demo.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @CrossOrigin
    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> findAllProducts() {
        return productRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Products findProductsById(@PathVariable("id") int id) {
       return productRepository.getOne(id);

    }
}