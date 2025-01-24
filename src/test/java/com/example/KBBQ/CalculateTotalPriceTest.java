package com.example.KBBQ;

import com.example.KBBQ.model.Cart;
import com.example.KBBQ.model.CartItem;
import com.example.KBBQ.repository.CartRepository;
import com.example.KBBQ.service.Cart.AddToCartService;
import com.example.KBBQ.service.Cart.CreateCartService;
import com.example.KBBQ.service.CartItem.CreateItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class CalculateTotalPriceTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private AddToCartService addToCartService;
    @InjectMocks
    private CreateCartService createCartService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_item_and_cart_when_add_to_cart_service_return_total_price() {

        createCartService.execute(null);
        Optional<Cart> cart = cartRepository.findById(1);
        if (cart.isPresent()) {
            Cart existingCart = cart.get();

            CartItem item1 = new CartItem();
            CartItem item2 = new CartItem();
            CartItem item3 = new CartItem();

            item1.setPrice(13.99);
            item1.setCartId(existingCart.getId());

            item2.setPrice(12.99);
            item2.setCartId(existingCart.getId());

            item3.setPrice(12.99);
            item3.setCartId(existingCart.getId());

            addToCartService.execute(1, item1);
            addToCartService.execute(1, item2);
            addToCartService.execute(1, item3);

            assertNotEquals(0.0, existingCart.getTotal());
            assertEquals(39.97, existingCart.getTotal());

        }


    }

}
