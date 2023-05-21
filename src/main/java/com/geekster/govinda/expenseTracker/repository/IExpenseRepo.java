package com.geekster.govinda.expenseTracker.repository;

import com.geekster.govinda.expenseTracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExpenseRepo extends JpaRepository<Expense,Long> {


}
