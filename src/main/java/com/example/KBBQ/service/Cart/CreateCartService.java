package com.example.KBBQ.service.Cart;

import com.example.KBBQ.Command;
import com.example.KBBQ.model.Cart;
import com.example.KBBQ.repository.CartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateCartService implements Command<Void, Cart> {

    private final CartRepository cartRepository;

    public CreateCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public ResponseEntity<Cart> execute(Void input) {
        Cart cart = new Cart();
        cart = cartRepository.save(cart);
        return ResponseEntity.ok(cart);
    }

}
