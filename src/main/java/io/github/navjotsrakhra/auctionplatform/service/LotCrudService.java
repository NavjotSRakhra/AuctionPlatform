package io.github.navjotsrakhra.auctionplatform.service;

import io.github.navjotsrakhra.auctionplatform.data.dao.Dao;
import io.github.navjotsrakhra.auctionplatform.data.dto.recieve.LotDto;
import io.github.navjotsrakhra.auctionplatform.data.model.Lot;
import io.github.navjotsrakhra.auctionplatform.security.data.dao.UserAccountDao;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class LotCrudService {

    private final Dao<Lot> lotDao;
    private final UserAccountDao userAccountDao;

    public LotCrudService(Dao<Lot> lotDao, UserAccountDao userAccountDao) {
        this.lotDao = lotDao;
        this.userAccountDao = userAccountDao;
    }


    public long saveLot(@Valid LotDto lotDto, String username) {
        var userAccount = userAccountDao.findByUsername(username);
        var lot = lotDto.toLot(userAccount.orElseThrow(UnknownError::new));

        validateLot(lot);

        lot = lotDao.save(lot);
        return lot.getId();
    }

    private void validateLot(Lot lot) {
        if (!lot.getStartTime().isBefore(lot.getEndTime()))
            throw new IllegalArgumentException("Start time must be before end time");
    }
}
