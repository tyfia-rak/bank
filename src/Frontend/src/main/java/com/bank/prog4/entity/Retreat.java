package com.bank.prog4.entity;
import lombok.*;


import java.sql.Date;

@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Retreat {
    private double amount;
    private Date transaction_date;
    private int id_account;
}
