package com.bank.atm.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Size(min = 4, max = 4, message = "PIN should cosist of 4 digits")
    @Pattern(regexp = "[0-9]*",
            message = "PIN should consist of digits")
    private String pin;

    @Column
    private Integer balance;


    public Account(String number, String pin, Integer balance) {
        this.number = number;
        this.pin = pin;
        this.balance = balance;
    }


}
