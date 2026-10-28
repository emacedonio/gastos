package com.gastos.proyect.service;

import com.gastos.proyect.dto.ExpenseRequest;
import com.gastos.proyect.dto.ExpenseResponse;
import com.gastos.proyect.model.Expense;

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
}
