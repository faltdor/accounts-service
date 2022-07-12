package com.faltdor.accountservice.controller;

import com.faltdor.accountservice.config.AccountsServiceConfig;
import com.faltdor.accountservice.entity.*;
import com.faltdor.accountservice.repositories.AccountsRepository;
import com.faltdor.accountservice.service.client.CardsFeignClient;
import com.faltdor.accountservice.service.client.LoansFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class AccountsController {

    private final AccountsRepository accountsRepository;

    private final AccountsServiceConfig accountsConfig;

    private final LoansFeignClient loansFeignClient;

    private final CardsFeignClient cardsFeignClient;

    @PostMapping( "/myAccount" )
    public Accounts getAccountDetails( @RequestBody Customer customer ) {

        Accounts accounts = accountsRepository.findByCustomerId( customer.getCustomerId() );
        if ( accounts != null ) {
            return accounts;
        } else {
            return null;
        }
    }

    @GetMapping( "/account/properties" )
    public String getPropertyDetails() throws JsonProcessingException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties( accountsConfig.getMsg(), accountsConfig.getBuildVersion(),
              accountsConfig.getMailDetails(), accountsConfig.getActiveBranches() );
        String jsonStr = ow.writeValueAsString( properties );
        return jsonStr;
    }

    @PostMapping( "/myCustomerDetails" )
    public CustomerDetails myCustomerDetails( @RequestBody Customer customer ) {

        Accounts accounts = accountsRepository.findByCustomerId( customer.getCustomerId() );
        List<Loans> loans = loansFeignClient.getLoansDetails( customer );
        List<Cards> cards = cardsFeignClient.getCardDetails( customer );

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccounts( accounts );
        customerDetails.setLoans( loans );
        customerDetails.setCards( cards );

        return customerDetails;
    }
}