package io.github.navjotsrakhra.auctionplatform.security.data.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Authority {
    ADMIN,
    USER;

    public SimpleGrantedAuthority getSimpleGrantedAuthority() {
        return new SimpleGrantedAuthority(name());
    }
}
