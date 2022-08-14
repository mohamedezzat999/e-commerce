package com.example.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "totale_prices")
    private double totalePrices;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Customer client;

    @OneToMany(mappedBy="cart")
    public List<Product> products;
}
