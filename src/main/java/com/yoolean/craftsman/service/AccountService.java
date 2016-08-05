package com.yoolean.craftsman.service;

import com.yoolean.craftsman.entity.Account;

/**
 * Created by harry on 16-8-4.
 */
public interface AccountService
{
    long createAccount( Account account );

    Account queryAccount( String username );

    void updateAccount( Account account );
}
