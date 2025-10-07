//package gov.nj.treas.NJDPB_API.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Slf4j
//@Configuration
//public class UserDetailsConfig {
//
//    @Value("${security.user.name}")
//    private String username;
//
//    @Value("${security.user.password}")
//    private String password;
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        log.info("Username used = ",username);
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username(username)
//                .password(password)
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//}
