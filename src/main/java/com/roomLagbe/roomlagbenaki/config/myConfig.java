//package com.roomLagbe.roomlagbenaki.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class myConfig extends WebSecurityConfiguration {
//    @Bean
//    public UserDetailsService getUserDetailService(){
//        return  new UserDetailImpl();
//    }
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider daoauthenticationProvider = new DaoAuthenticationProvider();
//        daoauthenticationProvider.setUserDetailsService(this.getUserDetailService());
//        daoauthenticationProvider.setPasswordEncoder(passwordEncoder());
//
//
//        return daoauthenticationProvider;
//    }
//
//    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//}
