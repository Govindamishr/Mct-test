package com.geekster.govinda.expenseTracker.controller;

import com.geekster.govinda.expenseTracker.model.Expense;
import com.geekster.govinda.expenseTracker.model.User;
import com.geekster.govinda.expenseTracker.service.TokenService;
import com.geekster.govinda.expenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expense")

public class ExpenseController {

    @Autowired
    ExpenseService expenseService;
    @Autowired
    TokenService authService;

    @PostMapping("/add")
    public ResponseEntity<String> addExpense(@Valid @RequestParam String email , @RequestParam String token , @RequestBody Expense expense){
        HttpStatus status;
        String msg = "";
        if(authService.authenticate(email,token))
        {
            User user =  authService.findUserByToken(token);
            expense.setUser(user);
            expenseService.addExpense((List<Expense>) expense);
            msg = " Post posted successfully";
            status = HttpStatus.OK;
        }
        else
        {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }
    @GetMapping("/getAllExpense")

    public List<Expense> getAllExpense(){
        return expenseService.getAllExpense();

    }

    @GetMapping("/expense/{id}")

    public Optional<Expense> getById (@PathVariable Long id){
        return expenseService.getById(id);
    }

    @DeleteMapping("/DeleteById/{id}")

    public String DeleteById(@PathVariable Long id){
        expenseService.deleteById(id);

        return "Deleted SuccessFully";
    }

    @PostMapping("/update/{id}")

    public String updateExpense(@PathVariable Long id , @RequestBody Expense expense ){
        return expenseService.updateExpense(id,expense);

    }
    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @GetMapping("/total-price")
    public BigDecimal getTotalPrice() {
        return expenseService.calculateTotalPrice();
    }

}
