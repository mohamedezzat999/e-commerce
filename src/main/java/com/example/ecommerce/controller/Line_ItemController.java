package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Line_Item;
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
    public List<Line_Item> getAllLineItems (){
        return line_itemService.getAllLineItems();
    }
    @GetMapping("/{id}")
    public Line_Item getLineItemById(@PathVariable Long id){
        return line_itemService.getLineItemById(id);
    }
    @PostMapping
    public void addLineItem(Line_Item line_item){
        line_itemService.addLineItem(line_item);
    }

}
