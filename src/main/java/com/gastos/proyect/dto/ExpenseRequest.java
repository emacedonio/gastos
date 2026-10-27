package com.gastos.proyect.dto;

import com.gastos.proyect.model.CategoryEnum;
import com.gastos.proyect.model.PaymentMethodEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseRequest {

    private Long id;
    private String description;
    private BigDecimal amount;
    private CategoryEnum category;
    private LocalDate date;
    private PaymentMethodEnum paymentMethod;
}
