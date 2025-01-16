package com.example.KBBQ.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="customers")
@Data
public class Customer {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "shipping_address")
    private String address;


}
