package com.example.KBBQ.service.CartItem;

import com.example.KBBQ.Command;
import com.example.KBBQ.model.CartItem;
import com.example.KBBQ.repository.CartItemsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateItemService implements Command<CartItem, CartItem> {

    private final CartItemsRepository cartItemsRepository;

    public CreateItemService(CartItemsRepository cartItemsRepository) {
        this.cartItemsRepository = cartItemsRepository;
    }

    public ResponseEntity<CartItem> execute(CartItem item) {
        CartItem savedItem = cartItemsRepository.save(item);
        return ResponseEntity.ok(savedItem);

    }


}
