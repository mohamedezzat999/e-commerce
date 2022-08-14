package com.example.ecommerce.model.dto;

import com.example.ecommerce.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private double totale_prices;
    private List<Product> products;

}
