package io.github.navjotsrakhra.auctionplatform.service;

import io.github.navjotsrakhra.auctionplatform.data.dao.Dao;
import io.github.navjotsrakhra.auctionplatform.data.dto.recieve.LotDto;
import io.github.navjotsrakhra.auctionplatform.data.model.Lot;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class LotCrudService {

    private final Dao<Lot> lotDao;

    public LotCrudService(Dao<Lot> lotDao) {
        this.lotDao = lotDao;
    }


    public long saveLot(@Valid LotDto lotDto) {
        var lot = lotDto.toLot();
        validateLot(lot);

        lot = lotDao.save(lot);
        return lot.getId();
    }

    private void validateLot(Lot lot) {
        if (!lot.getStartTime().isBefore(lot.getEndTime()))
            throw new IllegalArgumentException("Start time must be before end time");
    }
}
