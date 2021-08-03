package com.bank.atm.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String number;

    @Column
    private String pin;

    @Column
    private Integer balance;


    public Account(String number, String pin, Integer balance) {
        this.number = number;
        this.pin = pin;
        this.balance = balance;
    }


}
