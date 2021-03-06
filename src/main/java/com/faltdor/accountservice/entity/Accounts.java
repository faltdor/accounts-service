package com.faltdor.accountservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;


@Entity
@Getter
public class Accounts {

    @Column(name = "customer_id")
    private long customerId;
    @Column(name="account_number")
    @Id
    private long accountNumber;
    @Column(name="account_type")
    private String accountType;
    @Column(name = "branch_address")
    private String branchAddress;
    @Column(name = "create_dt")
    private LocalDate createDt;

}