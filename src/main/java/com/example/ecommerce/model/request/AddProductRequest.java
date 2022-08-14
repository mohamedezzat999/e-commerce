package com.example.ecommerce.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddProductRequest {
    private String name;
    private double price;

}
