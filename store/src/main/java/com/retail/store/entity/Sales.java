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
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;        // Name of sold item
    private String description; // Optional description
    private BigDecimal price;   // Sale price
    private Integer quantity;   // Quantity sold

    // Many sales can belong to one category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Optional: Many sales can belong to one customer
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
