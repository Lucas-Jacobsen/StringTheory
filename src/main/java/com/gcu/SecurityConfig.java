package com.gcu;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
    @Autowired
    private DataSource dataSource;


    //@Autowired
    //BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public void configAuthentication (AuthenticationManagerBuilder auth) throws Exception 
    { 
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()) //hashed pass
            .dataSource(dataSource)    //database connection
            .usersByUsernameQuery("SELECT USERNAME, PASSWORD, enabled FROM users WHERE USERNAME = ?")
            .authoritiesByUsernameQuery("select username, role from credentials where username=?");
       

        System.out.println("==========>" +  new BCryptPasswordEncoder().encode("test"));
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
    	 http.csrf().disable()
    	 .authorizeRequests()
    	 .antMatchers("/","/newCustomerResults","/images/**").permitAll()
         .anyRequest().authenticated()
         .and()
         .formLogin()
         .loginPage("/login/")
		.usernameParameter("username")
         .passwordParameter("password")
         .permitAll()
         .defaultSuccessUrl("/login/doLogin", true)
         .and()
         .logout().permitAll(); 
    }
    

  
}