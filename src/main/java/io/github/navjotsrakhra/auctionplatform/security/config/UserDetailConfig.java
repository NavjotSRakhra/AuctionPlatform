package io.github.navjotsrakhra.auctionplatform.security.config;

import io.github.navjotsrakhra.auctionplatform.security.data.dao.UserAccountDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserDetailConfig {

    @Bean
    public UserDetailsService userDetailsService(UserAccountDao userAccountDao) {
        return username -> userAccountDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found."));
    }
}
