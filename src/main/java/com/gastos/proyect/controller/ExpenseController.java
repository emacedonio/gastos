package com.gastos.proyect.controller;


import com.gastos.proyect.model.Expense;
//import com.gastos.proyect.repository.ExpenseRepository;
import com.gastos.proyect.service.ExpenseService;
import com.gastos.proyect.service.ExpenseServiveImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RestControllerAdvice
public class ExpenseController {

    @Autowired
    // private ExpenseRepository repo;

    @PostMapping("/api/expenses")
    public ResponseEntity<ExpenseServiveImpl> crearExpense (@RequestBody ExpenseServiveImpl nuevoExpense){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoExpense);
    }

//  VARIABLE NO DECLARADA, COMO TOMARLA DEL SERVICE
    @GetMapping("api/expenses")
    public List<Expense> fetchExpenseList() {
        return  expenseService.fetchExpenseList(expense);
    }

//  Falta GETMAPPING POR ID, UTILIZAR MAPPER
    @GetMapping("/api/expense/{id}")
    public List<>
    {
        return
    }

//  VARIABLE NO DECLARADA, COMO TOMARLA DEL SERVICE
    @PutMapping("api/expense/{id}")
    public Expense updateExpense(@RequestBody Expense expense, @PathVariable("id") Long expenseId) {
        return expenseService.updateExpense(expense, expenseId);
    }

}