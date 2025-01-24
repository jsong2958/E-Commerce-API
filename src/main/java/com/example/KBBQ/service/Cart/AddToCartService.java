package com.example.KBBQ.service.Cart;

import com.example.KBBQ.Command;
import com.example.KBBQ.model.Cart;
import com.example.KBBQ.model.CartItem;
import com.example.KBBQ.repository.CartItemsRepository;
import com.example.KBBQ.repository.CartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddToCartService {

    private final CartRepository cartRepository;


    public AddToCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public ResponseEntity<Cart> execute(Integer CartId, CartItem item) {

        Optional<Cart> cart = cartRepository.findById(CartId);

        if (cart.isPresent()) {

            item.setCartId(cart.get().getId());

            cart.get().addItem(item);
            cart.get().setTotal(item.getPrice() * item.getQuantity());
            return ResponseEntity.ok(cart.get());
        }

        return ResponseEntity.notFound().build();
    }
}
