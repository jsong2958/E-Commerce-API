package com.example.KBBQ.service.Cart;


import com.example.KBBQ.Query;
import com.example.KBBQ.model.Cart;
import com.example.KBBQ.repository.CartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCartService implements Query<Integer, Cart> {

    private final CartRepository cartRepository;

    public GetCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    @Override
    public ResponseEntity<Cart> execute(Integer id) {
        Optional<Cart> cart = cartRepository.findById(id);

        if (cart.isPresent()) {

            cart.get().setTotal();
            return ResponseEntity.ok(cart.get());
        }

        return ResponseEntity.notFound().build();
    }
}
