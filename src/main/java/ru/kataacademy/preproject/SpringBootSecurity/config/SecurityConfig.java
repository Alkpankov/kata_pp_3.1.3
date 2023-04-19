package ru.kataacademy.preproject.SpringBootSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.kataacademy.preproject.SpringBootSecurity.security.AuthProviderImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthProviderImpl authProvider;

    @Autowired
    public SecurityConfig(AuthProviderImpl authProvider) {
        this.authProvider = authProvider;
    }

    /** Настраиваем аутентификацию */
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authProvider);
    }
}
