package io.github.navjotsrakhra.auctionplatform.data.dto.recieve;

import io.github.navjotsrakhra.auctionplatform.data.model.Lot;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record LotDto(
        @NotNull String title,
        @NotNull String description,
        @NotNull Instant startTime,
        @NotNull Instant endTime
) {
    public Lot toLot() {
        return new Lot(title, description, startTime, endTime);
    }
}
