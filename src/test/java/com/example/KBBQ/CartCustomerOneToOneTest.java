package com.example.KBBQ;

import com.example.KBBQ.model.Cart;
import com.example.KBBQ.model.Customer;
import com.example.KBBQ.repository.CartRepository;
import com.example.KBBQ.service.Cart.AddCustomerToCartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


public class CartCustomerOneToOneTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private AddCustomerToCartService addCustomerToCartService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_cart_and_customer_test_one_to_one_mapping() {

        Customer customer = new Customer();
        customer.setName("John Doh");
        customer.setEmail("john.doh@example.com");
        customer.setPhoneNumber("111-111-1111");
        customer.setAddress("123 John Doh Street");


        Cart cart = new Cart();

        when(cartRepository.findById(cart.getId())).thenReturn(Optional.of(cart));

        addCustomerToCartService.execute(cart.getId(), customer);

        assertNotNull(cart.getCustomer(), "Should not be null");
        assertEquals(cart.getCustomer(), customer, "Should be equal");



    }

}
