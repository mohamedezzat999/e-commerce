package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private final CartService cartService;



    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping
    public List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }


    @GetMapping("/{id}")
    public Cart getCartById (@PathVariable Long id){
        return cartService.getCartById(id);
    }

    @PostMapping
    public void addCart (Cart cart){
        cartService.addCart(cart);
    }
}
