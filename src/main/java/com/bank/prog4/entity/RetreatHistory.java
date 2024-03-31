package com.bank.prog4.entity;

import lombok.*;

import java.sql.Date;
@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class RetreatHistory {
    private int id;
    private String firstName;
    private String lastName;
    private double amount;
    private Date transaction_date;


}
