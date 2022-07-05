package com.faltdor.accountservice.controller;

import com.faltdor.accountservice.repositories.AccountsRepository;
import com.faltdor.accountservice.entity.Accounts;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;


@RestController
@AllArgsConstructor
public class AccountsController {

    private final AccountsRepository accountsRepository;

    @GetMapping("/account/{customerId}")
    public Accounts getAccountDetails(@RequestParam UUID customerId) {
        return accountsRepository.findByCustomerId(customerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));
    }

}