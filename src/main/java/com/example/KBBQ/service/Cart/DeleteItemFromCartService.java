package com.example.KBBQ.service.Cart;

import com.example.KBBQ.Command;
import com.example.KBBQ.model.Cart;
import com.example.KBBQ.model.CartItem;
import com.example.KBBQ.model.DeleteItemFromCartCommand;
import com.example.KBBQ.repository.CartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteItemFromCartService implements Command<DeleteItemFromCartCommand, Void> {

    private final CartRepository cartRepository;


    public DeleteItemFromCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    @Override
    public ResponseEntity<Void> execute(DeleteItemFromCartCommand input) {
        Optional<Cart> cartOptional = cartRepository.findById(input.getCartId());
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();

            for (CartItem item : cart.getItems()) {
                if (item.getProduct().equals(input.getItemName())) {
                    cart.getItems().remove(item);
                    return ResponseEntity.noContent().build();
                }
                return ResponseEntity.notFound().build();
            }

        }
        return ResponseEntity.notFound().build();
    }
}
