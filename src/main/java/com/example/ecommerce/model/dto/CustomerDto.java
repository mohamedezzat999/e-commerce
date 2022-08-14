package com.example.ecommerce.model.dto;

import com.example.ecommerce.entity.Customer;
import lombok.Data;

@Data

public class CustomerDto extends Customer {

    private String username;
    private String email;

}
