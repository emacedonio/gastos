package com.gastos.proyect.repository;


import com.gastos.proyect.model.CategoryEnum;
import com.gastos.proyect.model.Expense;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
    List<Expense> findByCategory(CategoryEnum categoryEnum);
}


