package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.model.dto.ProductDto;
import com.example.ecommerce.model.request.AddProductRequest;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping(value = { "", "/" })
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @PostMapping
    public void addProduct (@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }


    @PutMapping("/{cartId}/products/{productId}")
    Product assignProductToCart(@PathVariable long cartId,
                                @PathVariable long productId){
       return productService.assignProductToCart(cartId,productId);
    }
}
