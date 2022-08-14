package com.example.ecommerce.service;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private final CartRepository cartRepository ;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    public Cart getCartById (Long id ){
        return cartRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void addCart(Cart cart){
        cartRepository.save(cart);
    }
}
