package com.gastos.proyect.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

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

    @NotBlank
    @Size(min = 3, max = 200)
//    TODO: la annotation Min aplica para numeros, para String es size (Corregido)
    private String description;


    @NonNull
    @Min(value = 0)
    @Column(nullable = false, precision = 12,scale = 2)
    private BigDecimal amount;

    @PastOrPresent(message = "La fecha del costo, no puede ser futura :3")
//      TODO: la annotation past no puede aplicar para una entity, lo que hace esta annotation es evaluar una fecha pasada a la establecida, normalmente va en los request (Revisar corrección)
    @NotBlank
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotBlank
    private CategoryEnum category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotBlank
    private CategoryEnum paymentMethod;
}
