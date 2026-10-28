package com.gastos.proyect.mapper;

import com.gastos.proyect.dto.ExpenseReqCategory;
import com.gastos.proyect.model.Expense;
import org.mapstruct.Mapper;


@Mapper(componentModel = "Spring")

public interface MapperCategory {

    Expense toEntity(ExpenseReqCategory expenseReqCategory);
}
