package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Line_Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Line_ItemRepository extends JpaRepository<Line_Item,Long> {
}
