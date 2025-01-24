package com.example.KBBQ.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteItemFromCartCommand {

    private Integer cartId;
    private String itemName;

}
