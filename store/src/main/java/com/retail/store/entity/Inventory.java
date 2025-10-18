package com.retail.store.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;            // Name of the inventory item
    private String description;     // Optional description
    private BigDecimal price;       // Price per item
    private Integer quantity;       // Available quantity

    @ManyToOne
    @JoinColumn(name = "category_id") // Foreign key to Category
    private Category category;

    // Optional: You can add more fields like supplier, SKU, etc.
}
