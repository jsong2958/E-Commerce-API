package com.example.KBBQ.service.Customer;

import com.example.KBBQ.Command;
import com.example.KBBQ.model.Customer;
import com.example.KBBQ.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<Customer, Customer> {

    private final CustomerRepository customerRepository;

    public CreateUserService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public ResponseEntity<Customer> execute(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(savedCustomer);
    }
}
