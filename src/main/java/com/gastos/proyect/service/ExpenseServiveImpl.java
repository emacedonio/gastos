package com.gastos.proyect.service;

import com.gastos.proyect.dto.ExpenseRequest;
import com.gastos.proyect.dto.ExpenseResponse;
import com.gastos.proyect.mapper.MapperId;
import com.gastos.proyect.model.CategoryEnum;
import com.gastos.proyect.model.Expense;
import com.gastos.proyect.model.PaymentMethodEnum;
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
    private MapperId mapperId;

    @Override
    public ExpenseResponse saveExpense(ExpenseRequest expense) {
        Expense expense1 = mapperId.toEntity(expense);
        expensetRepository.save(expense1);

        ExpenseResponse expenseResponse = mapperId.toResponse(expense1);
        return expenseResponse;
    }

    @Override
    public List<Expense>
    fetchExpenseList() {
        return (List<Expense>) expensetRepository.findAll();
    }

    @Override
    public Expense updateExpense(Expense expense, Long expenseId) {
        Expense expDB = expensetRepository.findById(expenseId).get();

        return expensetRepository.save(expDB);
    }

    @Override
    public void deleteExpenseById(Long expenseId) {
        expensetRepository.deleteById(expenseId);
    }

    //Metodo de filtrado en la clase CategoryEnum
    @Override
    public List<Expense> findByCategory(CategoryEnum categoryEnum) {
        return expensetRepository.findByCategory(categoryEnum);
    }

    //Metodo de filtrado por metodo de pago relacionado por el enum metodo de pago, tambien se detalla en la interface service
    @Override
    public  List<Expense> findByPayment(PaymentMethodEnum paymentMethodEnum){
        return expensetRepository.findByPaymentMethod(paymentMethodEnum);
    }
}