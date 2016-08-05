package com.yoolean.craftsman.service.impl;

import com.yoolean.craftsman.entity.Account;
import com.yoolean.craftsman.exception.DuplicateAccountException;
import com.yoolean.craftsman.repository.AccountRepository;
import com.yoolean.craftsman.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by harry on 16-8-5.
 */
@Component
public class AccountServiceImpl
    implements AccountService
{
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public long createAccount( Account account )
    {
        if( queryAccount( account.getUsername() ) != null )
        {
            throw new DuplicateAccountException(
                "The account with user name " + account.getUsername() + " aready exist" );
        }
        Account saved = accountRepository.save( account );
        return saved.getId();
    }

    @Override
    public Account queryAccount( String username )
    {
        return accountRepository.getByUsername( username );
    }

    @Override
    public void updateAccount( Account account )
    {
        accountRepository.save( account );
    }
}
