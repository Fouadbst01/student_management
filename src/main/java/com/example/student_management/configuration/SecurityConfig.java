package com.example.student_management.configuration;

import com.example.student_management.configuration.entities.User;
import com.example.student_management.configuration.services.UserDetailsServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsServiceImp userDetailsServiceImp;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(userDetailsServiceImp);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.formLogin();
        http.authorizeHttpRequests().antMatchers("/").permitAll();
        http.authorizeHttpRequests().antMatchers("/students/").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers("/students/delete","/students/add","/students/add","/students/edit").hasAnyAuthority("USER");
        http.logout().logoutSuccessUrl("/");
        http.authorizeHttpRequests().anyRequest().authenticated();
    }


}
