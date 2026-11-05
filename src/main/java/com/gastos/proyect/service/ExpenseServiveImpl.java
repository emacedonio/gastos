package com.gastos.proyect.service;

import com.gastos.proyect.dto.ExpenseDateReq;
import com.gastos.proyect.dto.ExpenseRequest;
import com.gastos.proyect.dto.ExpenseResponse;
import com.gastos.proyect.mapper.MapperFechas;
import com.gastos.proyect.mapper.MapperId;
import com.gastos.proyect.model.CategoryEnum;
import com.gastos.proyect.model.Expense;
import com.gastos.proyect.model.PaymentMethodEnum;
import com.gastos.proyect.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;


//Annotation
@Service
public class ExpenseServiveImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final MapperId mapperId;
    private final MapperFechas mapperFechas;

//  Constructor inyectar dependencias.
    public ExpenseServiveImpl(ExpenseRepository expenseRepository, MapperId mapperId, MapperFechas mapperFechas) {
        this.expenseRepository =expenseRepository;
        this.mapperId =mapperId;
        this.mapperFechas =mapperFechas;
    }

    //CREAR
    @Override
    public ExpenseResponse saveExpense(ExpenseRequest expense) {
        Expense expense1 = mapperId.toEntity(expense);
        expenseRepository.save(expense1);

        ExpenseResponse expenseResponse = mapperId.toResponse(expense1);
        return expenseResponse;
    }

    // FILTRADO POR FECHAS
    @Override
    public List <ExpenseResponse> findExpenseResponse(ExpenseDateReq expense) {
        List <Expense> findExpense = expenseRepository.findByDateBetween(expense.getFechaInicial(), expense.getFechaFinal());

        List <ExpenseResponse> expenseEntity = mapperFechas.toResponseList(findExpense);
        return expenseEntity;
    }

    //LEER
    @Override
    public List<Expense>
    fetchExpenseList() {
        return (List<Expense>) expenseRepository.findAll();
    }

    //UPDATE
    @Override
    public Expense updateExpense(Expense expense, Long expenseId) {
        Expense expDB = expenseRepository.findById(expenseId).get();
        return expenseRepository.save(expDB);
    }

    //DELETE
    @Override
    public void deleteExpenseById(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    //Metodo de filtrado en la clase CategoryEnum
    @Override
    public List<Expense> findByCategory(CategoryEnum categoryEnum) {
        return expenseRepository.findByCategory(categoryEnum);
    }

    //Metodo de filtrado por metodo de pago relacionado por el enum metodo de pago, tambien se detalla en la interface service
    @Override
    public  List<Expense> findByPayment(PaymentMethodEnum paymentMethodEnum){
        return expenseRepository.findByPaymentMethod(paymentMethodEnum);
    }
}