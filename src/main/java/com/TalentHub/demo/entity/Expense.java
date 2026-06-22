package com.TalentHub.demo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Expense{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal amount;

    private LocalDate date;


    @ManyToOne   // Many Expenses -----> One Category
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;



}
