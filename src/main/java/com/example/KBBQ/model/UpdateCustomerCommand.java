package com.example.KBBQ.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCustomerCommand {

    private Integer id;
    private Customer customer;


}
