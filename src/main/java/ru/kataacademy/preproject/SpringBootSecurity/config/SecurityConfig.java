package ru.kataacademy.preproject.SpringBootSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kataacademy.preproject.SpringBootSecurity.services.PersonDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PersonDetailsService personDetailsService;
    private final SuccessUserHandler successUserHandler;
    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService, SuccessUserHandler successUserHandler) {
        this.personDetailsService = personDetailsService;
        this.successUserHandler = successUserHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers( "/hello","/login","/error").permitAll()
                .anyRequest().denyAll()
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/process_login")
                .successHandler(successUserHandler)
                .failureUrl("/login?error")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");
    }


    @Override
    /** Настраиваем аутентификацию */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(personDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
