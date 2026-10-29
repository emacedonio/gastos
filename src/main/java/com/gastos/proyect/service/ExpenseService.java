package com.gastos.proyect.service;

import com.gastos.proyect.dto.ExpenseRequest;
import com.gastos.proyect.dto.ExpenseResponse;
import com.gastos.proyect.model.CategoryEnum;
import com.gastos.proyect.model.Expense;
import com.gastos.proyect.model.PaymentMethodEnum;

import java.util.List;


public interface ExpenseService {
    //save operation
    ExpenseResponse saveExpense(ExpenseRequest expense);

    //Read operation
    List<Expense>
    fetchExpenseList();

    //Update operation
    Expense updateExpense(Expense expense, Long expenseId);

    //Delete operation
    void deleteExpenseById(Long expenseId);

    //lista filtro category
    List<Expense> findByCategory(CategoryEnum categoryEnum);

    //lista que se extiende de nuestra entity de la cual se obtienen los datos, esta lista filtrara por metodo de pago.
    List<Expense> findByPayment(PaymentMethodEnum paymentMethodEnum);
}

