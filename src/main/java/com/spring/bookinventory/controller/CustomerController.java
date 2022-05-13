package com.spring.bookinventory.controller;

import com.spring.bookinventory.DAO.CustomerRepository;
import com.spring.bookinventory.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    @PostMapping(path="/customer", consumes="application/json")
    public Customer add(@RequestBody Customer customer){
        customerRepository.save(customer);
        return customer;
    }

    @RequestMapping(path="/customers")
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @RequestMapping(path="/customer/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable Integer customerId){
        return customerRepository.findById(customerId);
    }

    @PutMapping(path="/customer")
    public Customer saveOrUpdateCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return customer;
    }

    @DeleteMapping(path = "/customer/{customerId}")
    public String deleteCustomer(@PathVariable Integer customerId){
        customerRepository.deleteById(customerId);
        return "{\"message\" : \"Entity deleted successfully\"}";
    }
}
