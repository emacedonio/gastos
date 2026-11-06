package com.gastos.proyect.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    Anotaciones como @NotNull se colocan en el request, dentro del paquete model
    @NotBlank
    @Size(min = 3, max = 200)
    private String description;

    @NotNull
    @Min(value = 0)
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    //    correccion aplicada, linea 45
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private CategoryEnum category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private PaymentMethodEnum paymentMethod;

    @PreUpdate
    public void onUpdate() {
        this.date = LocalDate.now(ZoneId.of("America/Mexico_City"));

    }

    @PrePersist
    public void onCreate() {
        this.date = LocalDate.now(ZoneId.of("America/Mexico_City"));
    }
}