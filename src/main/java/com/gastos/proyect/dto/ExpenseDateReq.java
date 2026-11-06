package com.gastos.proyect.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDateReq {

    //Es necesario asignar los dos atributos de localDate inicio y final en el DTO para este Request

    private LocalDate fechaFinal;
    private LocalDate fechaInicial;
}
