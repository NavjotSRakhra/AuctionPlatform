package io.github.navjotsrakhra.auctionplatform.data.model;

import io.github.navjotsrakhra.auctionplatform.security.data.model.UserAccount;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Lot lot;
    private Instant bidTime;
    private BigDecimal bidAmount;
    @ManyToOne
    private UserAccount bidOwner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
