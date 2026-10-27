package com.gastos.proyect.service;

import com.gastos.proyect.model.Expense;
import com.gastos.proyect.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//Annotation
@Service
public class ExpenseServiveImpl

//Implenentating ExpenseService class

    implements ExpenseService {

    @Autowired
    private ExpenseRepository expensetRepository;

    @Override
    public Expense saveExpense(Expense expense) {
        return expensetRepository.save(expense);
    }

    @Override
    public List<Expense>
    fetchExpenseList() {
        return (List<Expense>) expensetRepository.findAll();
    }

    @Override
    public Expense updateExpense(Expense expense, Long expenseId){
        Expense expDB = expensetRepository.findById(expenseId).get();

        return expensetRepository.save(expDB);
    }

    @Override
    public void deleteExpenseById(Long expenseId){
        expensetRepository.deleteById(expenseId);
    }
}