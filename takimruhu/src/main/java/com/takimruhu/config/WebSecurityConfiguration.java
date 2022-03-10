package com.takimruhu.config;

import com.takimruhu.application.business.StandartJwtApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private  JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private  JwtRequestFilter jwtRequestFilter;

    private UserDetailsService standartJwtApplication;

    public WebSecurityConfiguration(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtRequestFilter jwtRequestFilter, UserDetailsService standartJwtApplication) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtRequestFilter = jwtRequestFilter;
        this.standartJwtApplication = standartJwtApplication;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
    return  super.authenticationManagerBean();
    }
    @Override
    protected  void  configure(HttpSecurity httpSecurity) throws Exception {
       httpSecurity.cors();
       httpSecurity.csrf().disable()
               .authorizeRequests()
               .antMatchers("/authenticate")
               .permitAll().antMatchers(HttpHeaders.ALLOW).permitAll()
               .anyRequest()
               .authenticated().and()
               .exceptionHandling()
               .authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

       httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
    {authenticationManagerBuilder.userDetailsService(standartJwtApplication).passwordEncoder(passwordEncoder());}


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/v1",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }




}



