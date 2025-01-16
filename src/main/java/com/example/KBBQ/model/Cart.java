package com.example.KBBQ.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "carts")
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "total")
    private double total;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id")
    private List<CartItem> items;

    public void addItem(CartItem item) {
        this.items.add(item);
    }

    public void setTotal() {
        for (CartItem item : items) {
            this.total += item.getPrice();
        }
    }

}
