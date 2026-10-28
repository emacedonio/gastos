package com.gastos.proyect.dto;


import com.gastos.proyect.model.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ExpenseRespCategory {
    private CategoryEnum category;

}
