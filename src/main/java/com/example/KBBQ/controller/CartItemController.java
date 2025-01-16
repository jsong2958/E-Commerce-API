package com.example.KBBQ.controller;

import com.example.KBBQ.model.CartItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.KBBQ.service.CartItem.*;

@RestController
@RequestMapping("/items")
public class CartItemController {


    private final CreateItemService createItemService;


    public CartItemController(CreateItemService createItemService) {
        this.createItemService = createItemService;
    }

    @PostMapping
    public ResponseEntity<CartItem> createItem(@RequestBody CartItem cartItem) {
        return createItemService.execute(cartItem);
    }
}
