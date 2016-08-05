package com.yoolean.craftsman.web;

import com.yoolean.craftsman.entity.Account;
import com.yoolean.craftsman.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by harry on 16-8-5.
 */
@Controller
public class RegistrationController
{
    @Autowired
    private AccountService accountService;

    @RequestMapping( value = "/register", method = RequestMethod.GET )
    public String showRegisterForm()
    {
        return "register";
    }

    @RequestMapping( value = "/register", method = RequestMethod.POST )
    public String register( Account account )
    {
        accountService.createAccount( account );
        return "login";
    }
}
