package io.github.navjotsrakhra.auctionplatform.service;

import io.github.navjotsrakhra.auctionplatform.data.dto.recieve.UserAccountRegisterDto;
import io.github.navjotsrakhra.auctionplatform.exception.UsernameTakenException;
import io.github.navjotsrakhra.auctionplatform.security.data.dao.UserAccountDao;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserAccountService {
    private final UserAccountDao userAccountDao;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserAccountService(UserAccountDao userAccountDao, PasswordEncoder passwordEncoder) {
        this.userAccountDao = userAccountDao;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUserAccount(@Valid UserAccountRegisterDto userAccountRegisterDto) {
        //Check if user already exists
        userAccountDao.findByUsername(userAccountRegisterDto.username()).ifPresent(userAccount -> {
            throw new UsernameTakenException(userAccountRegisterDto.username());
        });

        userAccountDao.save(userAccountRegisterDto.toUserAccount(passwordEncoder));
    }
}
