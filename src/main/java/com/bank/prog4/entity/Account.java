package com.bank.prog4.entity;

import lombok.*;

import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Account  {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private double bankBalance;
    private String bankName;
    private double salaryAmount;
    private Boolean overdraw;
}
