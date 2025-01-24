package com.example.KBBQ;

import com.example.KBBQ.model.Cart;
import com.example.KBBQ.model.Customer;
import org.springframework.http.ResponseEntity;

public interface Command<I, O> {
    ResponseEntity<O> execute (I input);

}
