package peaksoft.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;


@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder  userBuilder= User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("Malika")
                        .password("malika")
                                .roles("EMPLOYEE"))
                     .withUser(userBuilder.username("Nurisa")
                             .password("nurisa")
                             .roles("HR"))
                .withUser(userBuilder.username("Aigul")
                        .password("aigul")
                        .roles("HR","MANAGER"));


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").
                hasAnyRole("EMPLOYEE","HR","MANAGER")
                .antMatchers("/info_hr").hasRole("HR")
                .antMatchers("/info_manager").hasRole("MANAGER")
                .and()
                .formLogin().permitAll();
    }
}
