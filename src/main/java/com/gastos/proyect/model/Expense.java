package com.gastos.proyect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String description;

    @Column(nullable = false, precision = 12,scale = 12)
    private BigDecimal amount;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryEnum category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryEnum paymentMethod;
}
