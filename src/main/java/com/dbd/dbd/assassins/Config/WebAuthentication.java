package com.dbd.dbd.assassins.Config;

import com.dbd.dbd.assassins.Models.User;
import com.dbd.dbd.assassins.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inputName ->{
            User user = userRepository.findByEmail(inputName);

           if (user != null){

               return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), AuthorityUtils.createAuthorityList("user"));
           }else{
               throw new UsernameNotFoundException("No te encontre mostro");
           }

        });
    }
}
