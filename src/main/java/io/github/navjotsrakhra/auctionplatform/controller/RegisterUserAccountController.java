package io.github.navjotsrakhra.auctionplatform.controller;

import io.github.navjotsrakhra.auctionplatform.data.dto.recieve.UserAccountRegisterDto;
import io.github.navjotsrakhra.auctionplatform.service.RegisterUserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/register")
public class RegisterUserAccountController {
    private final RegisterUserAccountService registerUserAccountService;

    public RegisterUserAccountController(RegisterUserAccountService registerUserAccountService) {
        this.registerUserAccountService = registerUserAccountService;
    }

    @PostMapping
    public ResponseEntity<?> registerUserAccount(UserAccountRegisterDto userAccountRegisterDto) {
        registerUserAccountService.registerUserAccount(userAccountRegisterDto);
        return ResponseEntity.ok().build();
    }
}
