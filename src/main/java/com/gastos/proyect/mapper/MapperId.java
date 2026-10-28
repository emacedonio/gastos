package com.gastos.proyect.mapper;

import com.gastos.proyect.dto.ExpenseRequest;
import com.gastos.proyect.dto.ExpenseResponse;
import com.gastos.proyect.model.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface MapperId {

    // Mapeo cuando los atributos contienen el mismo nombre
    @Mapping(target = "id", ignore = true)
    Expense toEntity(ExpenseRequest expenseRequest);

    // Mapeo cuando contiene nombres distintos
    @Mapping(target = "descriptionResponse", source = "expense.description")
    ExpenseResponse toResponse(Expense expense);
}
