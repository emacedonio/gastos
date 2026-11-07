package com.gastos.proyect.controller;


import com.gastos.proyect.model.Expense;
import com.gastos.proyect.service.ExpenseService;
import com.gastos.proyect.service.ExpenseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RestControllerAdvice
public class ExpenseController {

    //  En caso de no funcionar revisar la Documentacion
    //      Inyección de la interfaz del service
    private final ExpenseService expenseService;

    //      Constructor de la inyección
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    //  1.-CREAR GASTO
    @PostMapping("/api/expenses")
    public ResponseEntity<ExpenseServiceImpl> crearExpense(@RequestBody ExpenseServiceImpl nuevoExpense) {

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

    //  4.-BORRAR GASTO
    @DeleteMapping("api/expenses/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable("id") Long expenseId) {
        expenseService.deleteExpenseById(expenseId);
        return ResponseEntity.noContent().build();
    }

//      Faltan endponits de los mappers
}