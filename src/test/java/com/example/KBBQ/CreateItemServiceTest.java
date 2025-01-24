package com.example.KBBQ;

import com.example.KBBQ.model.CartItem;
import com.example.KBBQ.repository.CartItemsRepository;
import com.example.KBBQ.service.CartItem.CreateItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreateItemServiceTest {

    @Mock
    private CartItemsRepository cartItemsRepository;

    @InjectMocks
    private CreateItemService createItemService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_cartItem_when_create_cartItem_service_return_cartItem_response_entity() {

        CartItem item = new CartItem();
        item.setProduct("Cake");
        item.setQuantity(2);
        item.setPrice(11.00);

        when(cartItemsRepository.save(item)).thenReturn(item);

        ResponseEntity<CartItem> response = createItemService.execute(item);

        assertNotNull(response);
        assertEquals(ResponseEntity.status(HttpStatus.OK).body(item), response);
        assertEquals(item, response.getBody());
        verify(cartItemsRepository).save(item);



    }

}
