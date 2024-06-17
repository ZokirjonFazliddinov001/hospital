//package uz.pdp.securityrolespring.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable);
//        http.authorizeHttpRequests(m -> m
//                .requestMatchers("/", "/about").permitAll()
//                .requestMatchers("/books", "/videos", "/musics").hasAnyRole("ADMIN", "STUDENT", "OPERATOR")
//                .requestMatchers("/comments").hasAnyRole("STUDENT", "OPERATOR")
//                .requestMatchers("/calls", "/students").hasRole("OPERATOR")
//                .requestMatchers("/students/admin", "/books/admin", "/videos/admin", "/musics/admin").hasRole("ADMIN")
//                .anyRequest()
//                .authenticated()
//        );
//
//        http.formLogin(m -> {
//
//        });
//
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails student = User
//                .withDefaultPasswordEncoder()
//                .username("s")
//                .password("s")
//                .roles("STUDENT")
//                .build();
//
//        UserDetails operator = User
//                .withDefaultPasswordEncoder()
//                .username("o")
//                .password("o")
//                .roles("OPERATOR")
//                .build();
//
//        UserDetails admin = User
//                .withDefaultPasswordEncoder()
//                .username("a")
//                .password("a")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(student, operator, admin);
//    }
//
//}
