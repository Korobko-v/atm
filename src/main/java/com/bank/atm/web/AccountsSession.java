package com.bank.atm.web;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsSession {
    private int accountId;
    private String number;

    public void clear() {
        accountId = 0;
        number = null;
    }
}
