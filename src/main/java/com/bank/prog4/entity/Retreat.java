package com.bank.prog4.entity;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Retreat implements Serializable {
    private int id;
    private double amount;
    private Date transaction_date;
    private int id_account;
}
