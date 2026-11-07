package com.gastos.proyect.service;

import com.gastos.proyect.dto.ExpenseDateReq;
import com.gastos.proyect.dto.ExpenseRequest;
import com.gastos.proyect.dto.ExpenseResponse;
import com.gastos.proyect.mapper.ExpenseMapper;
import com.gastos.proyect.model.CategoryEnum;
import com.gastos.proyect.model.Expense;
import com.gastos.proyect.model.PaymentMethodEnum;
import com.gastos.proyect.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//Annotation
@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

//  se agrega final para garantizar la inmutabilidad
    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    //CREAR
    @Override
    @Transactional
    public ExpenseResponse saveExpense(ExpenseRequest expense) {
        Expense expense1 = expenseMapper.toEntity(expense);
        expenseRepository.save(expense1);
        return expenseMapper.toResponse(expense1);
    }

    // FILTRADO POR FECHAS
    @Override
    @Transactional(readOnly = true)
    public List<ExpenseResponse> findExpenseResponse(ExpenseDateReq expense) {
        List<Expense> findExpense = expenseRepository.findByDateBetween(expense.getFechaInicial(), expense.getFechaFinal());
        return expenseMapper.toResponseList(findExpense);
    }

    //LEER
    @Override
    @Transactional(readOnly = true)
    public List<Expense> fetchExpenseList() {
        return expenseRepository.findAll();
    }

    //UPDATE
    @Override
    @Transactional
    public Expense updateExpense(Expense expense, Long expenseId) {
        Expense expDB = expenseRepository.findById(expenseId).get();
//        falta agregar el mapper de update y guardar el expense actualizado
        return expenseRepository.save(expDB);
    }

    //DELETE
    @Override
    public void deleteExpenseById(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    //Metodo de filtrado en la clase CategoryEnum
    @Override
    @Transactional(readOnly = true)
    public List<Expense> findByCategory(CategoryEnum categoryEnum) {
        return expenseRepository.findByCategory(categoryEnum);
    }

    //Metodo de filtrado por metodo de pago relacionado por el enum metodo de pago, tambien se detalla en la interface service
    @Override
    @Transactional(readOnly = true)
    public List<Expense> findByPayment(PaymentMethodEnum paymentMethodEnum) {
        return expenseRepository.findByPaymentMethod(paymentMethodEnum);
    }
}