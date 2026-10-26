package com.gastos.proyect.repository;


import com.gastos.proyect.model.CategoryEnum;
import com.gastos.proyect.model.Expense;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//TODO: aqui falta terminar el repository
public interface ExpenseRepository extends JpaRepository
    //List<Expense> findByCategoryOrderByDataDesc(CategoryEnum Category);
    //List<Expense> findByDateBetween(LocalDate start, LocalDate end);
}


