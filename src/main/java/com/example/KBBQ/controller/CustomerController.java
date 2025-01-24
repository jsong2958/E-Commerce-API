package com.example.KBBQ.controller;

import com.example.KBBQ.model.Customer;
import com.example.KBBQ.repository.CustomerRepository;
import com.example.KBBQ.service.Customer.CreateUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CreateUserService createUserService;
    private final CustomerRepository customerRepository;

    public CustomerController(CreateUserService createUserService,
                              CustomerRepository customerRepository) {
        this.createUserService = createUserService;
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return createUserService.execute(customer);
    }





}
