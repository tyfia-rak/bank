package com.bank.prog4.entity;
import lombok.*;

import java.util.Date;


@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Other_bank {
    private int id;
    private double amount;
    private String bank_name;
    private String transfer_reason;
    private Date effective_date;
    private Date registration_date;
    private int id_account;
}
