package com.bank.atm.model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Positive;

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
    @Length(min = 16, max = 16)
    @Positive
    private String number;

    @Column
    @Length(min = 4, max = 4)
    @Positive
    private String pin;

    @Column
    @Positive
    private Integer balance;

    public Account(String number, String pin, Integer balance) {
        this.number = number;
        this.pin = pin;
        this.balance = balance;
    }


}
