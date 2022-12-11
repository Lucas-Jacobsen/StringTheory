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
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()) 
            .dataSource(dataSource)    //database connection
            .usersByUsernameQuery("SELECT USERNAME, PASSWORD, enabled FROM credentials WHERE USERNAME = ?")
            .authoritiesByUsernameQuery("select username, role from credentials where username=?");
       

        System.out.println("==========>" +  new BCryptPasswordEncoder().encode("Jacobsen"));
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
    	 http.csrf().disable()
    	 .authorizeRequests()
    	 .antMatchers("/", "/doSignup","/service/getjson","/service/getproduct","/doSignupResults","/images/**").permitAll() //Protected 
         .anyRequest().authenticated()
         .and()
         .formLogin()
         .loginPage("/login/")
		 .usernameParameter("username")
         .passwordParameter("password")
         .permitAll()
         .defaultSuccessUrl("/login/doProducts", true)
         .and()
         .logout()
         .logoutUrl("/logout")
			.invalidateHttpSession(true)
			.clearAuthentication(true)
         .permitAll()
		 .and()
		  .exceptionHandling().accessDeniedPage("/login/");
    }

  
}