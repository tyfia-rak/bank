package com.bank.prog4.entity;
import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Category_transaction {
    private int id;
    private String name;
    private Date date;
    private int id_transaction;
}
