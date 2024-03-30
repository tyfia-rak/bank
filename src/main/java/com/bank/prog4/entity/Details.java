package com.bank.prog4.entity;

import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Details {
    private int id_account;
    private String firstName;
    private String lastName;
    private double bankBalance;
    private double loans;
    private double interest;
}
