package com.example.ecommerce.controller;

import com.example.ecommerce.entity.LineItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.Line_ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/line_item")
public class Line_ItemController {

    @Autowired
    private final Line_ItemService line_itemService;

    public Line_ItemController(Line_ItemService line_itemService) {
        this.line_itemService = line_itemService;
    }

    @GetMapping
    public List<LineItem> getAllLineItems (){
        return line_itemService.getAllLineItems();
    }
    @GetMapping("/{id}")
    public LineItem getLineItemById(@PathVariable Long id){
        return line_itemService.getLineItemById(id);
    }
    @PostMapping
    public void addLineItem(@RequestBody LineItem line_item){
        line_itemService.addLineItem(line_item);
    }
    @PutMapping("/{cartId}/lineItems/{LineItemId}")
    public LineItem assignLineItemToCart(@PathVariable long cartId,
                                        @PathVariable long LineItemId){
        return line_itemService.assignLineItemToCart(cartId,LineItemId);
    }
}
