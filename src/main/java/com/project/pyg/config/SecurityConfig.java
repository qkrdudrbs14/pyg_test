package com.project.pyg.config;

import com.project.pyg.service.MemberDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MemberDetailService memberDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        log.info("security config");

        http.authorizeRequests()
                .antMatchers("/login/**", "/resources/**", "/restApi/**").permitAll()
                .antMatchers("/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
        ;
//                .and().sessionManagement().maximumSessions(1).expiredUrl("/login").maxSessionsPreventsLogin(true);
//                .and().sessionManagement().maximumSessions(1).expiredUrl("/login").maxSessionsPreventsLogin(false);

        http.formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
//                .failureHandler(SecurityLoginFailHandler())
                .defaultSuccessUrl("/")
//                .successHandler(SecurityLoginSuccessHandler())
                .usernameParameter("username")
                .passwordParameter("password");

        http.exceptionHandling().accessDeniedPage("/accessDenied");

        http.headers().frameOptions().disable();
        http.headers().frameOptions().sameOrigin();

        http.logout().logoutUrl("/logout").invalidateHttpSession(true);

        http.userDetailsService(memberDetailService);
    }

    @Bean public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(memberDetailService).passwordEncoder(new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {

                return "";

            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {

                String rawPasswordStr = (String) rawPassword;
                String encodePassword = "";

                try {
                    encodePassword = EncBySha512(rawPasswordStr);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }

                return encodedPassword.equals(encodePassword);
            }

        });

    }
    public String EncBySha512(String password) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes());

        StringBuilder builder = new StringBuilder();

        for (byte b : md.digest()) {
            builder.append(String.format("%02x", b));
        }

//        return builder.toString();
        return password;
    }



}
