package com.example.KBBQ.controller;

import com.example.KBBQ.model.Cart;
import com.example.KBBQ.model.CartItem;
import com.example.KBBQ.model.Customer;
import com.example.KBBQ.model.DeleteItemFromCartCommand;
import com.example.KBBQ.service.Cart.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/cart")
public class CartController {



    private final CreateCartService createCartService;
    private final AddToCartService addToCartService;
    private final GetCartService getCartService;
    private final AddCustomerToCartService addCustomerToCartService;
    private final DeleteItemFromCartService deleteItemFromCartService;

    private Integer cartId;

    public CartController(CreateCartService createCartService,
                          AddToCartService addToCartService,
                          GetCartService getCartService,
                          AddCustomerToCartService addCustomerToCartService,
                          DeleteItemFromCartService deleteItemFromCartService) {
        this.createCartService = createCartService;
        this.addToCartService = addToCartService;
        this.getCartService = getCartService;
        this.addCustomerToCartService = addCustomerToCartService;
        this.deleteItemFromCartService = deleteItemFromCartService;
    }

    @PostMapping
    public ResponseEntity<Cart> createCart() {
        return createCartService.execute(null);
    }


    @PostMapping("/items/{cartId}")
    public ResponseEntity<Cart> addItemToCart(@PathVariable Integer cartId,
                                              @RequestBody CartItem item) {
        return addToCartService.execute(cartId, item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Integer id) {
        return getCartService.execute(id);
    }

    @PostMapping("/customer/{cartId}")
    public ResponseEntity<Cart> addCustomerToCart(@PathVariable Integer cartId,
                                                  @RequestBody Customer customer) {
        return addCustomerToCartService.execute(cartId, customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemFromCart(@PathVariable Integer id,
                                                   @RequestBody String item) {
        return deleteItemFromCartService.execute(new DeleteItemFromCartCommand(id, item));
    }



}
