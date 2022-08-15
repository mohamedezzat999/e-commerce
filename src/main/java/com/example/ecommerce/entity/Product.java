package com.example.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double price;


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name="cart_id",referencedColumnName = "id")
    private Cart cart;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "line_item_id")
    private Line_Item line_item;

    public void assignCart(Cart cart){
        this.cart = cart;
    }
}
