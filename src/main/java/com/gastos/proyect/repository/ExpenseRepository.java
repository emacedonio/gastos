package com.gastos.proyect.repository;


import com.gastos.proyect.model.CategoryEnum;
import com.gastos.proyect.model.Expense;
import com.gastos.proyect.model.PaymentMethodEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//  Se entiende que @Repository es redundante, al extender JpaRepository Spring sabe que esta interfaz es un componente de persistencia.
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

    List<Expense> findByCategory(CategoryEnum categoryEnum);

    // Se agrega el listado por el metodo de filtrado por metodo de pago en service
    List<Expense> findByPaymentMethod(PaymentMethodEnum paymentMethodEnum);

    List<Expense> findByDateBetween(LocalDate fechaInicial, LocalDate fechaFinal);

    //Revisar metodo, no esta siendo utilizado
    List<Expense> findByCategoryOrderByDateDesc(CategoryEnum category);
}


