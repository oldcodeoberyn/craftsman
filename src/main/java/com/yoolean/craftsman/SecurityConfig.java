package com.yoolean.craftsman;

import com.yoolean.craftsman.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by harry on 16-8-5.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig
    extends WebSecurityConfigurerAdapter
{
    @Autowired
    private AccountRepository accountRepository;

    @Override
    protected void configure( HttpSecurity http ) throws Exception
    {
        http
            .authorizeRequests().antMatchers( "/css/**","/js/**","/fonts/**", "/image/**","/index", "/register" ).permitAll().antMatchers( "/admin/**" )
            .hasRole( "ADMIN" ).anyRequest().fullyAuthenticated().and().formLogin().loginPage( "/login" )
            .failureUrl( "/login?error" ).permitAll().and().logout().permitAll();
    }

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception
    {
        auth.userDetailsService( new UserDetailsService()
        {
            @Override
            public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
            {
                return accountRepository.getByUsername( username );
            }
        } );
    }
}
