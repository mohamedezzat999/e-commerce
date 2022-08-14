package com.example.ecommerce.service;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.model.request.AddProductRequest;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    public void addProduct (AddProductRequest addProductRequest){
        Product product =new Product();
        product.setPrice(addProductRequest.getPrice());
        productRepository.save(product);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }


}
