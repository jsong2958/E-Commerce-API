package com.example.KBBQ.controller;

import com.example.KBBQ.model.Cart;
import com.example.KBBQ.model.CartItem;
import com.example.KBBQ.repository.CartRepository;
import com.example.KBBQ.service.Cart.AddToCartService;
import com.example.KBBQ.service.Cart.CreateCartService;
import com.example.KBBQ.service.Cart.GetCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/carts")
public class CartController {



    private final CreateCartService createCartService;
    private final AddToCartService addToCartService;
    private final GetCartService getCartService;

    private Integer cartId;

    public CartController(CreateCartService createCartService,
                          AddToCartService addToCartService,
                          GetCartService getCartService) {
        this.createCartService = createCartService;
        this.addToCartService = addToCartService;
        this.getCartService = getCartService;
    }

    @PostMapping
    public ResponseEntity<Cart> createCart() {
        return createCartService.execute(null);
    }


    @PostMapping("/{cartId}")
    public ResponseEntity<Cart> addItemToCart(@PathVariable Integer cartId,
                                              @RequestBody CartItem item) {
        return addToCartService.execute(cartId, item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Integer id) {
        return getCartService.execute(id);
    }



}
