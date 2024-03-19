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
    private String first_name;
    private String lastName;
    private Date birthday;
    private Double bank_balance;
    private String bank_name;
    private Double salary_amount;
    private Boolean overdraw;
}
