package com.example.ecommerce.service;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.LineItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.Line_ItemRepository;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private final CartRepository cartRepository ;
    public final ProductRepository productRepository;
    public final Line_ItemService line_itemService;
    public final Line_ItemRepository line_itemRepository;
    public CartService(CartRepository cartRepository, ProductRepository productRepository, Line_ItemService line_itemService, Line_ItemRepository line_itemRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.line_itemService = line_itemService;
        this.line_itemRepository = line_itemRepository;
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

    public void addToCart(long cartId, long productId , int quantity){
        Product product = productRepository.findById(productId).orElseThrow(RuntimeException::new);
        LineItem  lineItem = line_itemService.assignProductToLineItemAndGetIt(cartId,product,quantity);
        if(cartRepository.existsById(cartId)){
            Cart  cart1 = cartRepository.findById(cartId).orElseThrow(RuntimeException::new);
            lineItem.setCart(cart1);
            cart1.lineItems.add(lineItem);
            cart1.setTotalePrices(totalePrice(cart1,product.getPrice(),quantity));
            cartRepository.save(cart1);
        }
        else   {
            Cart cart2 = new Cart();
            lineItem.setCart(cart2);
            cart2.lineItems.add(lineItem);
            cart2.setTotalePrices(totalePrice(cart2,product.getPrice(),quantity));
            cartRepository.save(cart2);
        }
    }
    public double totalePrice(Cart cart,double price, int quantity){
        System.out.println(price * quantity);
        return cart.getTotalePrices()+(price * quantity);
    }
}

