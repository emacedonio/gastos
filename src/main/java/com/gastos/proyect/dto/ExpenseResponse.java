package com.gastos.proyect.dto;

import com.gastos.proyect.model.CategoryEnum;
import com.gastos.proyect.model.PaymentMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponse {

    private String descriptionResponse;
    private BigDecimal amount;
    private CategoryEnum category;
    private LocalDate date;
    private PaymentMethodEnum paymentMethod;
}
