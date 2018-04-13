package com.waldek.demo.repository;

import com.waldek.demo.dto.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository{

    private static List<Account> userDB = new ArrayList<>();

    static {
        userDB.add(new Account("1", "waldek", "wr357ok"));
    }

    @Override
    public Account findByUsername(String name) {
        return userDB.stream().filter(x -> x.getUsername().equals(name)).findFirst().get();
    }
}
