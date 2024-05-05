package io.github.navjotsrakhra.auctionplatform.data.repository;

import io.github.navjotsrakhra.auctionplatform.data.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotRepository extends JpaRepository<Lot, Long> {
}
