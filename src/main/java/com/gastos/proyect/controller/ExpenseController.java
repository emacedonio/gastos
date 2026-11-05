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

    private ExpenseService expenseService;

//  1.-CREAR GASTO
    @PostMapping("/api/expenses")
    public ResponseEntity<ExpenseServiveImpl> crearExpense (@RequestBody ExpenseServiveImpl nuevoExpense){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoExpense);
    }

//  2.-OBTENER GASTOS
    @GetMapping("api/expenses")
    public ResponseEntity<List<Expense>> fetchExpenseList() {

        List<Expense> expenses = expenseService.fetchExpenseList();
        return ResponseEntity.ok(expenses);
    }

//  3.-ACTUALIZAR GASTOS
    @PutMapping("api/expense/{id}")
    public Expense updateExpense(@RequestBody Expense expense, @PathVariable("id") Long expenseId) {
        return expenseService.updateExpense(expense, expenseId);
    }

// 4.-BORRAR GASTO
    @DeleteMapping("api/expenses/{id}")
    public
}