package io.github.navjotsrakhra.auctionplatform.data.dto.recieve;

import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record LotDto(
        @NotNull String title,
        @NotNull String description,
        @NotNull Instant startTime,
        @NotNull Instant endTime
) {
}
