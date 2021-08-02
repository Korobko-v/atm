package com.bank.atm.model;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Length(min = 16, max = 16)
    @Positive
    private Integer number;

    @Column
    @Length(min = 4, max = 4)
    @Positive
    private Integer pin;

    @Column
    @Positive
    private Integer balance;

}
