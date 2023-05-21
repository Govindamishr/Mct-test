package com.geekster.govinda.expenseTracker.repository;

import com.geekster.govinda.expenseTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {

    User findFirstByEmail(String email);
    User findByUserId(Long id);

}
