package com.gastos.proyect.dto;


import com.gastos.proyect.model.PaymentMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseMetReq {

    //agregar por ulr al igual que el filtrado por categoria
    private PaymentMethodEnum paymentMethod;
}
