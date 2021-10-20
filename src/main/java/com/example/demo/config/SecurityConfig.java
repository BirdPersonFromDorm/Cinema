package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/user/home").access("hasRole('Admin')") // доступ к страницце только ТЕМ кто админ
                .antMatchers(HttpMethod.POST, "/user/add").access("hasRole('Admin')") // same
                .antMatchers(HttpMethod.GET, "/user/user/home").access("hasRole('User')")
                .antMatchers(HttpMethod.GET, "/films").access("hasRole('Admin')") //доступ к странице только тем у кого роль пользователя.
                .antMatchers("/user/admin").permitAll()
                //Доступ всем, для того чтоб СОЗДАТЬ админа
                    .and()
                .formLogin()
                .permitAll()
                    .and()
                .logout()
                .logoutSuccessUrl("/");

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userDetailsService);

    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}