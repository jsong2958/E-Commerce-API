package com.example.KBBQ;

import com.example.KBBQ.model.Cart;
import com.example.KBBQ.model.CartItem;
import com.example.KBBQ.model.Customer;
import com.example.KBBQ.repository.CartRepository;
import com.example.KBBQ.service.Cart.GetCartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GetCartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private GetCartService getCartService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_customer_and_cart_items_when_get_cart_service_return_cart_response_entity() {

        Cart cart = new Cart();
        cart.setId(1);


        Customer customer = new Customer();
        customer.setName("John Doh");
        customer.setEmail("john.doh@example.com");
        customer.setPhoneNumber("111-111-1111");
        customer.setAddress("123 John Doh Street");

        List<CartItem> items = new ArrayList<>();
        CartItem item1 = new CartItem();
        item1.setProduct("Chadol");
        item1.setQuantity(1);
        item1.setPrice(18.99);
        item1.setCartId(1);
        items.add(item1);

        CartItem item2 = new CartItem();
        item2.setProduct("Bulgogi");
        item2.setQuantity(2);
        item2.setPrice(29.99);
        item2.setCartId(1);
        items.add(item2);

        cart.setCustomer(customer);
        cart.setItems(items);

        when(cartRepository.findById(1)).thenReturn(Optional.of(cart));

        ResponseEntity<Cart> response = getCartService.execute(1);

        assertEquals(ResponseEntity.ok(cart), response);
        verify(cartRepository, times(1));




    }
}
