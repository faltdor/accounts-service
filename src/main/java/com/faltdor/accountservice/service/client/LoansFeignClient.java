package com.faltdor.accountservice.service.client;

import com.faltdor.accountservice.entity.Customer;
import com.faltdor.accountservice.entity.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient( "loan-service" )
public interface LoansFeignClient {

    @RequestMapping( method = RequestMethod.POST, value = "myLoans", consumes = "application/json" )
    List<Loans> getLoansDetails( @RequestBody Customer customer );
}
