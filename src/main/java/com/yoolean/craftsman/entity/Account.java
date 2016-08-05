package com.yoolean.craftsman.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * Created by harry on 16-8-4.
 */
@Entity
public class Account
    implements UserDetails
{
    public enum Role
    {
        USER, ADMIN
    };

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private String email;
    private Date registrationDate=new Date();
    @Enumerated( value = EnumType.STRING )
    private Role role = Role.USER;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return Arrays.asList(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public String getUsername()
    {
        return username;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled()
    {
        return enabled;
    }

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole( Role role )
    {
        this.role = role;
    }

    public void setAccountNonExpired( boolean accountNonExpired )
    {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked( boolean accountNonLocked )
    {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired( boolean credentialsNonExpired )
    {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled( boolean enabled )
    {
        this.enabled = enabled;
    }
}
