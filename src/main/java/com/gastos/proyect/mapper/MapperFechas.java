package com.gastos.proyect.mapper;


import com.gastos.proyect.dto.ExpenseDateReq;
import com.gastos.proyect.dto.ExpenseDateResp;
import com.gastos.proyect.dto.ExpenseResponse;
import com.gastos.proyect.model.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "Spring")
public interface MapperFechas {

    @Mapping(target = "date", ignore = true)
    Expense toEntityFecha(ExpenseDateReq expenseDateReq);

    List<ExpenseResponse> toResponseList(List<Expense> expenses);
}
