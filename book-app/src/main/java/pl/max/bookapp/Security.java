package pl.max.bookapp;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class Security extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("admin")
                .password ("admin")
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Override


    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/xd").permitAll()
                .antMatchers("/booksShow").hasRole("admin")
                .antMatchers("/api/books").hasRole("admin")
                .and()
                .authorizeRequests().antMatchers("/console/**").permitAll()
                .and().formLogin()
                .and().logout().permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }



}

