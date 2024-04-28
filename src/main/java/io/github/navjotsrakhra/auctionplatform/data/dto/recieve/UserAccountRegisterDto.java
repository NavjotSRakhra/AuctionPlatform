package io.github.navjotsrakhra.auctionplatform.data.dto.recieve;

import io.github.navjotsrakhra.auctionplatform.security.data.model.Authority;
import io.github.navjotsrakhra.auctionplatform.security.data.model.UserAccount;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public record UserAccountRegisterDto(
        @NotNull String username,
        @NotNull String password,
        @NotNull @Email String email,
        @Nullable List<Authority> authorities) {
    public UserAccount toUserAccount(PasswordEncoder passwordEncoder) {
        var password = passwordEncoder.encode(this.password());

        return new UserAccount(username, password, email, authorities);
    }
}
