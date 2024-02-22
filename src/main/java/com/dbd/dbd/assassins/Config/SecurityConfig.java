package com.dbd.dbd.assassins.Config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //configuraciones

        http.authorizeHttpRequests(ant -> ant.requestMatchers("/index.html","/style.css","/addKiller.js").permitAll()
                        .requestMatchers("/img/**").permitAll()
                .requestMatchers(HttpMethod.POST,"/api/user","/api/login").permitAll())
            .csrf(csrf -> csrf.disable())
            .headers( headers -> headers.frameOptions(options -> options.disable()));
        http.formLogin(formLogin ->

                formLogin.loginPage("/index.html")
                        .loginProcessingUrl("/api/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .successHandler((request, response, authentication) -> clearAuthenticationAttributes(request))
                        .failureHandler((request, response, exception) -> response.sendError(403)))
                .logout(logout -> logout.logoutUrl("/api/logout")
                        .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                        .deleteCookies("JSESSIONID") )
                .rememberMe(Customizer.withDefaults());


        return  http.build();
    }


    private void clearAuthenticationAttributes( HttpServletRequest request){

        HttpSession session = request.getSession(false);

        if(session != null){
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }

    }
}
