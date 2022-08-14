package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.model.dto.CustomerDto;
import com.example.ecommerce.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
    @RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers (){
        return customerService.getAllCustomers().stream().map(post -> modelMapper.map(post, CustomerDto.class))
                .collect(Collectors.toList());    }


    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
    @PostMapping
    public void createUser(CustomerDto customerDto){
        customerService.createCustomer(customerDto);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        customerService.updateUser(id,customerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @PostMapping ("{id}/add")
    public void addItems(@PathVariable Long id,Long product_id){
        customerService.addItems(id,product_id);
    }
}
