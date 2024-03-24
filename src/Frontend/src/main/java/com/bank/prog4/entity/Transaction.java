package com.bank.prog4.entity;
import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Transaction {
    private int id;
    private Date date_transaction;
    private String reference;
    private String motif;
    private double credit;
    private double debit;
    private int id_account;
}
