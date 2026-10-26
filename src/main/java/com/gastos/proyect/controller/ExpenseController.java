package com.gastos.proyect.controller;


import com.gastos.proyect.model.Expense;
//import com.gastos.proyect.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RestControllerAdvice
public class ExpenseController {

    @Autowired
    // private ExpenseRepository repo;

    @PostMapping("/crear")
    public Expense crarExpense(@RequestBody Expense nuevoExpense) {
        return nuevoExpense;
    }


}