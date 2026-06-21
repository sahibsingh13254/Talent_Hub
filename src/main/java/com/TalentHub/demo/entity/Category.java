package com.TalentHub.demo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "categories")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // Inverse side - "mappedBy" means Expense owns the foreign key.
    // Never serialize this list directly in a response; it'll recurse
    // back into expense.category.expenses... forever.
    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    private List<Expense> expenses = new ArrayList<>();

  }
