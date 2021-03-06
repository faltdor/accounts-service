package com.faltdor.accountservice.entity;

import lombok.Data;

import java.util.Date;


@Data
public class Loans {
    private int loanNumber;

    private int customerId;

    private Date startDt;

    private String loanType;

    private int totalLoan;

    private int amountPaid;

    private int outstandingAmount;

    private String createDt;
}
