package com.example.ecommerce.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "line_item")
public class LineItem {
    @Id
    @GeneratedValue
    private long id;
    private int quantity = 0;

    @ManyToMany(mappedBy="lineItems")
    private List<Product> products = new ArrayList<>();
    @JsonIgnore
    @ManyToOne
    private Cart cart;

    public void assignCart(Cart cart) {
        this.cart = cart;
    }

    public void assignProduct(Product product) {
        products.add(product);
    }

}
