package com.example.ecommerce.service;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.model.dto.CustomerDto;
import com.example.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers (){
        List<Customer> list1 = customerRepository.findAll();
//        List<CustomerDto> list2 = new ArrayList<>();
//        for (Customer customer : list1){
//            customerDto.setUsername(customer.getUsername());
//            customerDto.setEmail(customer.getEmail());
//            list2.add(customerDto);
//        }
        return list1;
    }
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void createCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setUsername(customerDto.getUsername());
        customer.setPassword(customerDto.getPassword());
        customer.setEmail(customerDto.getEmail());
        customerRepository.save(customer);
    }

    public void updateUser(Long id, CustomerDto customerDto){
        Customer currentCustomer = customerRepository.findById(id).orElseThrow(RuntimeException::new);
        currentCustomer.setUsername(customerDto.getUsername());
        currentCustomer.setEmail(customerDto.getEmail());
        currentCustomer.setPassword(customerDto.getPassword());
        customerRepository.save(currentCustomer);
    }
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
    ProductService productService;
    public void addItems(Long id ,Long product_id){
        Cart cart = new Cart();
       // cart.products.add(productService.getProductById(id));
    }
}
