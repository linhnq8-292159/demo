package com.linhnq.demo.service;

import com.linhnq.demo.entity.Product;
import com.linhnq.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {

        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        if (product != null) {
            return productRepo.save(product);
        }
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        if (product != null) {
            Product productToUpdate = productRepo.findById(id).get();
            if (productToUpdate != null) {
                productToUpdate.setName(product.getName());
                productToUpdate.setYear(product.getYear());

                return
            }
            return productRepo.save(product);
        }
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}
