package com.cognizant.tutorial.service.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("UserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

        http.csrf().disable()
//            .authorizeRequests()
//                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers("/tutorial").permitAll()
//                .antMatchers("/tutorial/register").permitAll()
//                .antMatchers("/tutorial/login").permitAll()
//                .antMatchers("/api/rest/home/**").permitAll()
//                .antMatchers("/api/rest/admin/**").hasRole("ADMIN")
//                .antMatchers("/api/rest/user/**").hasAnyRole("ADMIN", "USER")
//                .anyRequest().authenticated().and()
//            .formLogin()
//                .loginPage("/tutorial/login")
//                .loginProcessingUrl("/tutorial/auth")
//                .defaultSuccessUrl("/tutorial/main", true)
//                .failureUrl("/tutorial/home");
            ;
        // Needed to disable iframe reload in H2
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(encodePassword());
    }
}
