package com.example.ecommerce.service;
import com.example.ecommerce.entity.Line_Item;
import com.example.ecommerce.repository.Line_ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Line_ItemService {
    @Autowired
    private final Line_ItemRepository line_itemRepository;


    public Line_ItemService(Line_ItemRepository line_itemRepository) {
        this.line_itemRepository = line_itemRepository;
    }
    public List<Line_Item> getAllLineItems (){
        return line_itemRepository.findAll();
    }

    public Line_Item getLineItemById (Long id){
        return line_itemRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    public void addLineItem(Line_Item line_item){
        line_itemRepository.save(line_item);
    }
    public void deleteLineItem (Long id){
        line_itemRepository.deleteById(id);
    }

}
