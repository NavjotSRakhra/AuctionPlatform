package io.github.navjotsrakhra.auctionplatform.controller;

import io.github.navjotsrakhra.auctionplatform.data.dto.recieve.LotDto;
import io.github.navjotsrakhra.auctionplatform.service.LotCrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/lot")
public class LotCrudController {

    private final LotCrudService lotCrudService;

    public LotCrudController(LotCrudService lotCrudService) {
        this.lotCrudService = lotCrudService;
    }


    @PostMapping("/add")
    public ResponseEntity<Long> addLot(LotDto lotDto, Principal principal) {
        return ResponseEntity.ok(
                lotCrudService.saveLot(lotDto, principal.getName())
        );
    }
}
