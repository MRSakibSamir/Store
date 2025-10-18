package com.retail.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email; // example field for customer contact

    // Optional: reference to a favorite category
    @ManyToOne
    @JoinColumn(name = "category_id") // foreign key column
    private Category category;
}
