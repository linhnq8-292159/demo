package com.linhnq.demo.service;

import com.linhnq.demo.entity.Product;

public interface IProductService {

    //get all products
    public List<Product> getAllProducts();

    //get product by id
    public Product getProductById(Long id);
    public Product addProduct(Product product);

    public Product updateProduct(Long id, Product product);

    //delete product by id
    public boolean deleteProduct(Long id);


}
