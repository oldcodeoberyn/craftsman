package com.yoolean.craftsman.repository;

import com.yoolean.craftsman.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by harry on 16-8-4.
 */
public interface AccountRepository
    extends JpaRepository<Account, Long>
{
    Account getByUsername(String username);
}
