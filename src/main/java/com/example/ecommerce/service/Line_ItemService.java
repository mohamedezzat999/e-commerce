package com.example.ecommerce.service;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.LineItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.Line_ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Line_ItemService {
    @Autowired
    private final Line_ItemRepository line_itemRepository;
    private final CartRepository cartRepository;

    public Line_ItemService(Line_ItemRepository line_itemRepository, CartRepository cartRepository) {
        this.line_itemRepository = line_itemRepository;
        this.cartRepository = cartRepository;
    }

    public LineItem assignLineItemToCart(long cartId, long lineItemId) {
            LineItem lineItem = line_itemRepository.findById(lineItemId).get();
            Cart cart = cartRepository.findById(cartId).get();
            lineItem.assignCart(cart);
            return line_itemRepository.save(lineItem);
    }

    public List<LineItem> getAllLineItems (){
        return line_itemRepository.findAll();
    }

    public LineItem getLineItemById (Long id){
        return line_itemRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    public void addLineItem(LineItem line_item){
        line_itemRepository.save(line_item);
    }
    public void deleteLineItem (Long id){
        line_itemRepository.deleteById(id);
    }


    public int addQuantity(LineItem lineItem,int quantity) {
        return lineItem.getQuantity()+quantity;
    }

    public LineItem assignProductToLineItemAndGetIt (long cartId,Product product,int quantity){
        List<LineItem> lineItems =  getAllLineItems();
        Cart cart = cartRepository.findById(cartId).orElseThrow(RuntimeException::new);
        boolean existLineItem = false;
        LineItem lineItem = null;
        for (int i=0 ;i<lineItems.size();i++){
             lineItem = lineItems.get(i);
            if (lineItem.getProducts().contains(product)) {
                if (lineItem.getCart() ==cart){
                    int newQuantity = this.addQuantity(lineItem, quantity);
                    lineItem.setQuantity(newQuantity);
                    existLineItem = true;
            }
            else {
                    existLineItem = true;
                    lineItem.setQuantity(quantity);
                }
            }
        }
        if(!existLineItem) {
             lineItem = new LineItem();
                lineItem.assignProduct(product);
                product.lineItems.add(lineItem);
                int newQuantity = this.addQuantity(lineItem,quantity);
                lineItem.setQuantity(newQuantity);
        }
        return line_itemRepository.save(lineItem);
    }
}
