package com.gastos.proyect.service;

import com.gastos.proyect.model.Expense;

import java.util.List;

public interface ExpenseService {
    //save operation
    Expense saveExpense(Expense expense);

    //Read operation
    List<Expense>
    fetchExpenseList();

    //Update operation
    Expense updateExpense(Expense expense, Long expenseId);

    //Delete operation
    void deleteExpenseById(Long expenseId);
}
