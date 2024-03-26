package com.novemberecho.Authentication.config;

import com.novemberecho.Authentication.Entity.User;
import com.novemberecho.Authentication.Service.CustomUserDetails;
import com.novemberecho.Authentication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserService userService;

    //BCrypt to encode all passwords
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/accounts/home**",
                                "/js/**",
                                "/css/**",
                                "/img/**",
                                "/accounts/registration",
                                "/accounts/login",
                                "/book/**",
                                "/").permitAll()
                        .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.loginPage("/accounts/login")
                        //.loginProcessingUrl("/accounts/login")
                        .permitAll() //permit all users to access login page
                        //.failureUrl("/login?error= true")
                        .defaultSuccessUrl("/accounts/home", true)
                )
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/accounts/logout"))
                        .logoutSuccessUrl("/accounts/login?logout") //once user clicks on logout, it redirects to login screen with logout message
                        .permitAll())
                .exceptionHandling((exception) -> exception.accessDeniedPage("/accounts/accessDenied"));

        return http.build();
    }

    //to integrate spring data jpa and hibernate with spring security
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        //auth.userDetailsService(userService);
    }
}