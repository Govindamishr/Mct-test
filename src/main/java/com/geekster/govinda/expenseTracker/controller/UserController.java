package com.geekster.govinda.expenseTracker.controller;

import com.geekster.govinda.expenseTracker.dto.SignInInput;
import com.geekster.govinda.expenseTracker.dto.SignInOutput;
import com.geekster.govinda.expenseTracker.dto.SignUpOutput;
import com.geekster.govinda.expenseTracker.model.User;
import com.geekster.govinda.expenseTracker.service.TokenService;
import com.geekster.govinda.expenseTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService authService;


    @PostMapping("signUp")

    public SignUpOutput signUp(@RequestBody User signUpDto){
        return userService.signUp(signUpDto);

    }

    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }
}
