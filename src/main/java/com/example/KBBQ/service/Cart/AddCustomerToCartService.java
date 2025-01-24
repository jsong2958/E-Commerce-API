package com.example.KBBQ.service.Cart;

import com.example.KBBQ.Command;
import com.example.KBBQ.model.Cart;
import com.example.KBBQ.model.Customer;
import com.example.KBBQ.repository.CartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddCustomerToCartService {

    private final CartRepository cartRepository;

    public AddCustomerToCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }



    public ResponseEntity<Cart> execute(Integer cartId, Customer customer) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            cart.get().addCustomer(customer);

            return ResponseEntity.ok(cart.get());
        }

        return ResponseEntity.notFound().build();
    }
}
