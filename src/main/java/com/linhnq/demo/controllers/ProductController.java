package com.linhnq.demo.controllers;

import com.linhnq.demo.entity.Product;
import com.linhnq.demo.entity.ResponseObject;
import com.linhnq.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    @Autowired
    private ProductRepo repo;


    @GetMapping("")
    List<Product> getAllProducts() {
        return repo.findAll();
    }

    //Get detail product
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Product> foundProduct = repo.findById(id);
        return foundProduct.isPresent() ?
                ResponseEntity.ok().body(
                    new ResponseObject( "OK", "Query product successfully", foundProduct)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false", "Cannot find product with id = " + id, "")
                );
        };

}
