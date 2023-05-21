package com.geekster.govinda.expenseTracker.service;

import com.geekster.govinda.expenseTracker.model.Expense;
import com.geekster.govinda.expenseTracker.repository.IExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service

public class ExpenseService {
    @Autowired
    IExpenseRepo iExpenseRepo;
    public String addExpense(List<Expense> expenseList) {
        iExpenseRepo.saveAll(expenseList);

        return "Added expenditure";

    }

    public List<Expense> getAllExpense() {
        return iExpenseRepo.findAll();
    }

    public Optional<Expense> getById(Long id) {

        return iExpenseRepo.findById(id);
    }

    public void deleteById(Long id) {
        iExpenseRepo .deleteById(id);
    }

    public String updateExpense(Long id, Expense expense) {
        Optional<Expense> ExpenseList = iExpenseRepo.findById(id);
        expense.setId(id);
        if (ExpenseList.isEmpty()) {
            return "Book with Book Id: " + id + " not found";
        }
        else  {
            iExpenseRepo.save(expense);
            return "Book with Book Id: " + id + " updated successfully";}
    }

    @Autowired
    public ExpenseService(IExpenseRepo iExpenseRepo) {
        this.iExpenseRepo = iExpenseRepo;
    }

    public BigDecimal calculateTotalPrice() {
        List<Expense> expenses = iExpenseRepo.findAll();
        BigDecimal total = BigDecimal.ZERO;

        for (Expense expense : expenses) {
            total = total.add(expense.getPrice());
        }

        return total;
    }
}
