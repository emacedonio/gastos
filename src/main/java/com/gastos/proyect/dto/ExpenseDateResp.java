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
public class ExpenseDateResp {


    //Es necesario asignar los dos atributos de localDate inicio y final en el DTO para este Response

    private LocalDate fechaFinal;
    private LocalDate fechaInicial;
}
