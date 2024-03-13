package com.bank.prog4.entity;
import lombok.*;


@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Loans_bank_interest {
    private int id;
    private double loans;
    private double interest;
    private int id_account;
}
