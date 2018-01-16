package com.creativeyann.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        	.headers().frameOptions().sameOrigin().and()
        	.headers().cacheControl().disable().and()
                .authorizeRequests()
					//.antMatchers("/", "/resume", "/projects", "/contact").permitAll()
					//.antMatchers("/css/**","/img/**","/resumes/**").permitAll()
					.antMatchers("/admin/**").hasAnyRole("ADMIN")
					//.anyRequest().authenticated()
					.anyRequest().permitAll()
                .and()
                .formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
                .logout()
					.permitAll()
					.and()
                .exceptionHandling().accessDeniedPage("/error");
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
       
    }
    
    @Value("${login.password}")
    private String password;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("admin").password(password).roles("ADMIN");
    }
}