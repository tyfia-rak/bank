package com.bank.prog4.entity;

import lombok.*;

import java.sql.Date;

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
    private Double bankBalance;
    private String bankName;
    private Double salaryAmount;
    private Boolean overdraw;
}
