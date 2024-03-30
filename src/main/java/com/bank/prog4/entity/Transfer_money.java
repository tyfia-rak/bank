package com.bank.prog4.entity;

import lombok.*;

import java.sql.Date;

@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Transfer_money {
    private int id;
    private int credit_account;
    private int debit_account;
    private double amount;
    private String transfer_reason;
    private java.sql.Date effective_date;
    private java.sql.Date registration_date;


}
