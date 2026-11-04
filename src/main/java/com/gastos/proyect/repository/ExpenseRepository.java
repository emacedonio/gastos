package com.gastos.proyect.repository;


import com.gastos.proyect.model.CategoryEnum;
import com.gastos.proyect.model.Expense;
import com.gastos.proyect.model.PaymentMethodEnum;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

    List<Expense> findByCategory(CategoryEnum categoryEnum);

    // Se agrega el listado por el metodo de filtrado por metodo de pago en service
    List<Expense> findByPaymentMethod(PaymentMethodEnum paymentMethodEnum);

    // Nombre del metodo JPA revisar
    List<Expense> findByDateBetween(LocalDate fechaInicial, LocalDate fechaFinal);

    //Revisar nombre del motodo
    List<Expense> findByCategoryOrderByDateDesc(CategoryEnum category);
}


