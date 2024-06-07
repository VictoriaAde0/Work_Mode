package com.employee.Work_Mode.Security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public abstract class WebSecurityConfigurerAdapter {

    protected abstract void configure(HttpSecurity httpSecurity) throws Exception;

    protected AuthenticationManager authenticationManagerBean() {
        return null;
    }
}
