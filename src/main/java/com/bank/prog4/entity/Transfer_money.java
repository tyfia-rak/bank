package com.bank.prog4.entity;

import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Transfer_money {
    private int id;
    private int credit_account;
    private int account_receivable;
    private double amount;
    private String transfer_reason;
    private String type;
    private Date effective_date;
    private Date registration_date;
}
