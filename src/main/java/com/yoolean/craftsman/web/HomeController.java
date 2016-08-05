package com.yoolean.craftsman.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by harry on 16-8-5.
 */
@Controller
@RequestMapping( value = "/" )
public class HomeController extends WebMvcConfigurerAdapter
{
    @GetMapping( "/" )
    public String home()
    {
        return "home";
    }

    @GetMapping( "/home" )
    public String index()
    {
        return "home";
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}
