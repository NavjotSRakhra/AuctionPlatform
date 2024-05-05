package io.github.navjotsrakhra.auctionplatform.data.dao;

import io.github.navjotsrakhra.auctionplatform.data.model.Lot;
import io.github.navjotsrakhra.auctionplatform.data.repository.LotRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class LotDao implements Dao<Lot> {

    private final LotRepository lotRepository;

    public LotDao(LotRepository lotRepository) {
        this.lotRepository = lotRepository;
    }

    @Override
    public Lot save(Lot lot) {
        Objects.requireNonNull(lot);
        return lotRepository.save(lot);
    }

    @Override
    public Lot update(Lot lot) {
        Objects.requireNonNull(lot);
        return lotRepository.save(lot);
    }

    @Override
    public Lot delete(Lot lot) {
        Objects.requireNonNull(lot);
        lotRepository.delete(lot);
        return lot;
    }

    @Override
    public Optional<Lot> findById(Long id) {
        Objects.requireNonNull(id);
        return lotRepository.findById(id);
    }

    @Override
    public List<Lot> findAll() {
        return lotRepository.findAll();
    }
}
