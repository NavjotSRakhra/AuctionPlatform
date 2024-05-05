package io.github.navjotsrakhra.auctionplatform.security.data.dao;

import io.github.navjotsrakhra.auctionplatform.data.dao.Dao;
import io.github.navjotsrakhra.auctionplatform.security.data.model.UserAccount;
import io.github.navjotsrakhra.auctionplatform.security.repository.UserAccountRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UserAccountDao implements Dao<UserAccount> {
    private final UserAccountRepository userAccountRepository;

    public UserAccountDao(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        Objects.requireNonNull(userAccount);
        return this.userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        Objects.requireNonNull(userAccount);
        return this.userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount delete(UserAccount userAccount) {
        Objects.requireNonNull(userAccount);
        this.userAccountRepository.delete(userAccount);
        return userAccount;
    }

    @Override
    public Optional<UserAccount> findById(Long id) {
        Objects.requireNonNull(id);
        return this.userAccountRepository.findById(id);
    }

    @Override
    public List<UserAccount> findAll() {
        return this.userAccountRepository.findAll();
    }

    public Optional<UserAccount> findByUsername(String username) {
        Objects.requireNonNull(username);
        return userAccountRepository.findByUsername(username);
    }
}
