package com.waldek.demo.repository;

import com.waldek.demo.dto.Account;

public interface AccountRepository {
    Account findByUsername(String name);
}
