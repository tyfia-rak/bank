package com.bank.prog4.entity;

import java.io.Serializable;
import java.sql.Date;
public class Account implements Serializable {
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private Double MonthlySalary;
    private String accountNumber;
}
