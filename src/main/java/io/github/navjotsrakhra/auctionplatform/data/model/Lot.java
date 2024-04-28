package io.github.navjotsrakhra.auctionplatform.data.model;

import io.github.navjotsrakhra.auctionplatform.security.data.model.UserAccount;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Instant startTime;
    private Instant endTime;
    @ManyToOne
    private UserAccount owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
