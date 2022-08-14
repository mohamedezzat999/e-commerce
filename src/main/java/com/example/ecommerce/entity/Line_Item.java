package com.example.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "line_item")
public class Line_Item {
    @Id
    @GeneratedValue
    private long id;
    private int quantity;

    @OneToMany(mappedBy="line_item")
    private List<Product> products;

}
