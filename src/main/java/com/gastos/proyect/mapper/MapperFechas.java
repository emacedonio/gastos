package com.gastos.proyect.mapper;


import com.gastos.proyect.dto.ExpenseDateReq;
import com.gastos.proyect.dto.ExpenseDateResp;
import com.gastos.proyect.model.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "Spring")
public interface MapperFechas {

    @Mapping(target = "date", ignore = true)
    Expense toEntityFecha(ExpenseDateReq expenseDateReq);

    @Mapping(target = "dateResponse", source = "date")
    ExpenseDateResp toResponseDate(Expense expense);
}
