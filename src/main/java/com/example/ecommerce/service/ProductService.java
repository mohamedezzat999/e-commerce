package com.example.ecommerce.service;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.LineItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.model.dto.ProductDto;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.Line_ItemRepository;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    private final Line_ItemRepository lineItemRepository;

    public ProductService(ProductRepository productRepository, Line_ItemRepository lineItemRepository) {
        this.productRepository = productRepository;
        this.lineItemRepository = lineItemRepository;
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    public void addProduct (ProductDto productDto){
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        productRepository.save(product);
    }

    public Product assignProductToLineItem (Long lineItemsId ,Long productId){
        Product product = productRepository.findById(productId).get();
        LineItem lineItem = lineItemRepository.findById(lineItemsId).get();
        product.lineItems.add(lineItem);
        lineItem.assignProduct(product);
        lineItemRepository.save(lineItem);
        return productRepository.save(product);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }


}
