package io.github.navjotsrakhra.auctionplatform.data.dto.recieve;

import io.github.navjotsrakhra.auctionplatform.data.model.Lot;
import io.github.navjotsrakhra.auctionplatform.security.data.model.UserAccount;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record LotDto(
        @NotNull String title,
        @NotNull String description,
        @NotNull Instant startTime,
        @NotNull Instant endTime
) {

    public Lot toLot(UserAccount userAccount) {
        return new Lot(title, description, startTime, endTime, userAccount);
    }
}
