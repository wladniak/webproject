package pl.wla.webproject.rest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableJms
public class WebprojectConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails wla1 = User.builder().username("wla1").password("{noop}wla1").roles("ROLE1").build();
        UserDetails wla2 = User.builder().username("wla2").password("{noop}wla2").roles("ROLE2").build();
        UserDetails wla3 = User.builder().username("wla3").password("{noop}wla3").roles("ROLE3").build();
        return new InMemoryUserDetailsManager(wla1, wla2, wla3);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/getCustomers").hasRole("ROLE1")
                .anyRequest().permitAll();

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
