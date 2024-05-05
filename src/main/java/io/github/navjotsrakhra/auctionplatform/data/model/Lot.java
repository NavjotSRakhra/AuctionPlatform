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
    private UserAccount lotOwnerAccount;

    public Lot() {
    }

    public Lot(String title, String description, Instant startTime, Instant endTime, UserAccount userAccount) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.lotOwnerAccount = userAccount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public UserAccount getLotOwnerAccount() {
        return lotOwnerAccount;
    }

    public void setLotOwnerAccount(UserAccount lotOwnerAccount) {
        this.lotOwnerAccount = lotOwnerAccount;
    }
}
