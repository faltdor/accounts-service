package com.faltdor.accountservice.entity;

import lombok.Data;

import java.util.List;


@Data
public class CustomerDetails {

    private Accounts accounts;

    private List<Loans> loans;

    private List<Cards> cards;
}