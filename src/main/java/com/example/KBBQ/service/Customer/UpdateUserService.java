package com.example.KBBQ.service.Customer;

import com.example.KBBQ.Command;
import com.example.KBBQ.model.Customer;
import com.example.KBBQ.model.UpdateCustomerCommand;
import com.example.KBBQ.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService implements Command<UpdateCustomerCommand, Customer> {

    private final CustomerRepository customerRepository;


    public UpdateUserService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public ResponseEntity<Customer> execute(UpdateCustomerCommand input) {
        Optional<Customer> customerOptional = customerRepository.findById(input.getId());
        if (customerOptional.isPresent()) {
            Customer customer = input.getCustomer();
            customer.setId(input.getId());
            customerRepository.save(customer);
            return ResponseEntity.ok(customer);

        }
        return ResponseEntity.notFound().build();
    }
}


