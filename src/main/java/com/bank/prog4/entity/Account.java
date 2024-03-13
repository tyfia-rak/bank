package com.bank.prog4.entity;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;
@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Account implements Serializable {
    private String first_name;
    private String lastName;
    private Date birthday;
    private Double bank_balance;
    private String bank_name;
    private String salary_amount;
}
