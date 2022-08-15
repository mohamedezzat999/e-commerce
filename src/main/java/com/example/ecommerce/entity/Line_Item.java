package com.example.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "line_item")
public class Line_Item {
    @Id
    @GeneratedValue
    private long id;
    private int quantity;
    @JsonIgnore
    @OneToMany(mappedBy="line_item")
    private List<Product> products;

}
