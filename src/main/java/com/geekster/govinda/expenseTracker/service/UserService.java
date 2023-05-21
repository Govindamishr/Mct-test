package com.geekster.govinda.expenseTracker.service;

import com.geekster.govinda.expenseTracker.dto.SignInInput;
import com.geekster.govinda.expenseTracker.dto.SignInOutput;
import com.geekster.govinda.expenseTracker.dto.SignUpOutput;
import com.geekster.govinda.expenseTracker.model.AuthenticationToken;
import com.geekster.govinda.expenseTracker.model.User;
import com.geekster.govinda.expenseTracker.repository.ITokenRepo;
import com.geekster.govinda.expenseTracker.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service

public class UserService {
    @Autowired
    IUserRepo iUserRepo;


    @Autowired
    TokenService tokenService;


    public SignUpOutput signUp(User signUpDto) {

        //check if user exists or not based on email
        User user = iUserRepo.findFirstByEmail(signUpDto.getEmail());

        if(user != null)
        {
            throw new IllegalStateException(" user already exists!!!!...sign in instead");
        }
        //encryption
        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        signUpDto.setPassword(encryptedPassword);
        iUserRepo.save(signUpDto);

        return new SignUpOutput("User user registered","User account created successfully");




    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(password.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);

        return hash;

    }

    public SignInOutput signIn(SignInInput signInDto) {
        //check if user exists or not based on email
        User user = iUserRepo.findFirstByEmail(signInDto.getEmail());

        if(user == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInDto.getPassword());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(user.getPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

        //set up output response

        return new SignInOutput("Authentication Successfull !!!", token.getToken());


    }

}
